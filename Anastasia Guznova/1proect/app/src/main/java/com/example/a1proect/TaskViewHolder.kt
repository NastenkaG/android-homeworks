package com.example.a1proect

import androidx.recyclerview.widget.RecyclerView
import com.example.a1proect.databinding.ItemTaskBinding

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(task: Task) = with(binding) {
        textViewNameTask.text = task.nameTask
        textViewTime.text = task.time
    }
}
