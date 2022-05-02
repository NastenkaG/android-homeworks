package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
@RequiresApi(Build.VERSION_CODES.O)

class TasksDatabase {
    val tasks = listOf(
        Task(
            name = "send a report",
            time = LocalDateTime.now()
        ),
        Task(
            name = "prepare documents in the archive",
            time = LocalDateTime.now()
        )
    )
    val twoTasks = listOf(
        Task(
            name = "buy a cactus",
            time = LocalDateTime.now()
        ),
        Task(
            name = "buy a book",
            time = LocalDateTime.now()
        )
    )
    val threeTasks = listOf(
        Task(
            name = "lecture at 18:00",
            time = LocalDateTime.now()
        ),
        Task(
            name = "make a presentation on philosophy",
            time = LocalDateTime.now()
        ),
        Task(
            name = "buy blocks for a notebook",
            time = LocalDateTime.now()
        ),
        Task(
            name = "pick up the certificate from the deconate",
            time = LocalDateTime.now()
        )
    )
}
