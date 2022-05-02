package com.example.a1proect

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.FragmentPagerBinding
import java.time.LocalDateTime

class PagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentPagerBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dateTime = LocalDateTime.now()
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        val databaseManager = DatabaseManager(context)
//        databaseManager.insertTask(
//            Task(
//                nameTask = "Say Hi dkjhbfdhog shrthrtfglmfngh",
//                time = dateTime
//            )
//        )

//        val tasks = listOf(
//            Task(
//                nameTask = "Say Hi dkjhbfdhog shrthrtfglmfngh",
//                time = dateTime
//            ),
//            Task(
//                nameTask = "Fill out the documents",
//                time = dateTime
//            ),
//            Task(
//                nameTask = "Send documents",
//                time = dateTime
//            )
//        )
        val adapter = TasksAdapter()
        binding.recyclerViewWork.adapter = adapter
//        adapter.submitList(tasks)
        adapter.submitList(databaseManager.getTasks())
        binding.button.setOnClickListener {
//            adapter.addItem(
            databaseManager.insertTask(
                Task(
                    nameTask = "Print documents",
                    time = dateTime
                )
            )
            adapter.submitList(databaseManager.getTasks())
        }
        return binding.root
    }
}
