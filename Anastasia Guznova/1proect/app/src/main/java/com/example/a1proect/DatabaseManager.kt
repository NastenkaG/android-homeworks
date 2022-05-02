package com.example.a1proect

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class DatabaseManager(context: Context?) : SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION
    ) {

    companion object{
        private const val DATABASE_NAME = "my_database"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME_TASKS = "Tasks"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME_TASKS(id INTEGER PRIMARY KEY AUTOINCREMENT, nameTask TEXT, time TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertTask(task: Task){
        val timeString = task.time.toString()
        writableDatabase.insert(
            TABLE_NAME_TASKS,
            null,
            ContentValues().apply {
                put("nameTask", task.nameTask)
                put("time", timeString)
            }
        )
    }

    fun updateTask(id: Int, task: Task) {
        val timeString = task.time.toString()
        writableDatabase.update(
            TABLE_NAME_TASKS,
            ContentValues().apply {
                put("nameTask", task.nameTask)
                put("time", timeString)
            },
            "id = ?",
            arrayOf(id.toString())
        )
    }

    fun deleteTask(id: Int) {
        writableDatabase.delete(
            TABLE_NAME_TASKS,
            "id = ?",
            arrayOf(id.toString())
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTasks(): List<Task>{
        val cursor = readableDatabase.query(
            TABLE_NAME_TASKS,
            arrayOf("id", "nameTask", "time"),
            null,
            null,
            null,
            null,
            null,

        )
        val tasks = mutableListOf<Task>()
        with(cursor){
            if (moveToFirst()){
                do {
                    tasks.add(
                        Task(
                            nameTask = getString(getColumnIndexOrThrow("nameTask")),
                            time = LocalDateTime.parse(getString(getColumnIndexOrThrow("time")))
                        )
                    )
                } while (moveToNext())
            }
            close()
        }
        close()
        return tasks
    }
}
