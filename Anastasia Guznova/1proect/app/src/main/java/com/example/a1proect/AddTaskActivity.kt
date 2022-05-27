package com.example.a1proect

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a1proect.databinding.ActivityAddTaskBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTaskActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val preferenceManager = PreferenceManager(this)
        binding.imageCloseAddTask.setOnClickListener {
            finish()
        }
        binding.imageDoneAddTask.setOnClickListener {
            ApiService.retrofit.putTask(
                AddTask(binding.logTextInputEditTask.text.toString()),
                "Bearer ${preferenceManager.readFromPreferenceToken()}"
            ).enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    Toast.makeText(
                        this@AddTaskActivity,
                        "Добавлено",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Toast.makeText(
                        this@AddTaskActivity,
                        t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            finish()
        }
    }
}
