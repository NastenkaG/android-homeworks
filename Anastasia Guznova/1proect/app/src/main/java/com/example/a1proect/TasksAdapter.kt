package com.example.a1proect

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.a1proect.databinding.ItemTaskBinding

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private val item = mutableListOf<GettingTasks>()
    var onItemClick: (Int) -> Unit = {}
    var onItemLongClick: (Int) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(item[position], onItemClick, onItemLongClick)
    }

    override fun getItemCount() = item.size

    fun submitList(tasks: List<GettingTasks>) {
        item.clear()
        item.addAll(tasks)
        notifyDataSetChanged()
    }

    fun removeItem(taskId: Int) {
        val position = item.indexOfFirst { it.id == taskId }
        item.removeAt(position)
        notifyItemRemoved(position)
    }
}
