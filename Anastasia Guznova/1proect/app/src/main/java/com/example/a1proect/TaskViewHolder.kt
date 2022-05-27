package com.example.a1proect

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.a1proect.databinding.ItemTaskBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(
        task: GettingTasks,
        onItemClick: (Int) -> Unit,
        onItemLongClick: (Int) -> Unit,
    ) = with(binding) {
        textViewNameTask.text = task.text
//        checkBox.isChecked = task.isCompleted
        textViewTime.text = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.yyyy"))
        checkBox.setOnClickListener {
            checkBox.isChecked
            onItemClick.invoke(task.id)
        }

        root.setOnClickListener {
            checkBox.isChecked = !checkBox.isChecked
            onItemClick.invoke(task.id)
//            binding.checkBox.isChecked = !binding.checkBox.isChecked
        }
        root.setOnLongClickListener {
            onItemLongClick.invoke(task.id)
            true
//            val preferenceManager = PreferenceManager(this@TaskViewHolder)
//            ApiService.retrofit.deleteTask(task.id, "Bearer ${preferenceManager.readFromPreferenceToken()}")
//                .enqueue(object: Callback<Unit> {
//                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
//                        TODO("Not yet implemented")
//                    }
//
//                    override fun onFailure(call: Call<Unit>, t: Throwable) {
//                        TODO("Not yet implemented")
//                    }
//                })
        }
    }
}
