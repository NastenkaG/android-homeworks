package com.example.a1proect

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.RecyclerViewWorkBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RecyclerViewWork : Fragment() {
    lateinit var binding: RecyclerViewWorkBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dateTime = LocalDateTime.now()
        binding = RecyclerViewWorkBinding.inflate(inflater, container, false)

        val tasks = listOf(
            Task(
                nameTask = "Say Hi dkjhbfdhog shrthrtfglmfngh",
                time = dateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.yyyy"))
            ),
            Task(
                nameTask = "Fill out the documents",
                time = dateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.yyyy"))
            ),
            Task(
                nameTask = "Send documents",
                time = dateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.yyyy"))
            )
        )
        val adapter = TasksAdapter()
        binding.recyclerViewWork.adapter = adapter
        adapter.submitList(tasks)
        binding.button.setOnClickListener {
            adapter.addItems(
                Task(
                    nameTask = "Print documents",
                    time =
                        dateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.yyyy"))
                )
            )
        }
        return binding.root
    }

}