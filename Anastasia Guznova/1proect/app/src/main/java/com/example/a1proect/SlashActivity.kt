package com.example.a1proect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a1proect.databinding.ActivityMainBinding
import com.example.a1proect.databinding.ActivitySlashBinding

class SlashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySlashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}