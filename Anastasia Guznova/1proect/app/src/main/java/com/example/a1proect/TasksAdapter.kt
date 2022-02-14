package com.example.a1proect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a1proect.databinding.ItemTaskBinding

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private val items = mutableListOf<Task>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun submitList(tasks: List<Task>){
        items.clear()
        items.addAll(tasks)
        notifyDataSetChanged()
    }

    fun addItems(task: Task){
        items.add(task)
        notifyItemInserted(items.lastIndex)
    }
}