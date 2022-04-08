package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentPagerBinding
import java.time.LocalDateTime

class PagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentPagerBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        val adapter = TasksAdapter()
        val task = TasksDatabase()
        binding.recyclerViewPager.adapter = adapter
        adapter.submitList(
            when (position) {
                0 -> task.tasks
                1 -> task.twoTasks
                2 -> task.threeTasks
                else -> emptyList()
            }
        )
        binding.newTasksButton.setOnClickListener {
            adapter.addItem(
                Task(
                    name = "meeting at 15:00",
                    time = LocalDateTime.now()
                )
            )
        }
        return binding.root
    }
}
