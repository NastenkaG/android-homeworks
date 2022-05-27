package com.example.a1proect

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.FragmentPagerBinding
import java.time.LocalDateTime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val adapter = TasksAdapter()
        binding.recyclerViewWork.adapter = adapter
        val preferenceManager = PreferenceManager(requireContext() as AddTaskActivity)
        ApiService.retrofit.getTasks("Bearer ${preferenceManager.readFromPreferenceToken()}")
            .enqueue(object : Callback<List<GettingTasks>> {
                override fun onResponse(
                    call: Call<List<GettingTasks>>,
                    response: Response<List<GettingTasks>>
                ) {
                    adapter.submitList(response.body()!!)
                    Toast.makeText(requireContext(), "OK", Toast.LENGTH_SHORT).show()
                }
                override fun onFailure(call: Call<List<GettingTasks>>, t: Throwable) {
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })

        binding.button.setOnClickListener {
            val intent = Intent(context, AddTaskActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}
