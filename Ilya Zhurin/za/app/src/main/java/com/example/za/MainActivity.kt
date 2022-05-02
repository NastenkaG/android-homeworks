package com.example.za

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.za.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ButtonSignMain.setOnClickListener {
            val password = binding.editTextPasswordLoginMain.text.toString()
            val email = binding.editTextEmailLoginMain.text.toString()
            val valid = Validator(this)
            binding.inputLayoutEmailLoginMain.error = valid.checkEmail(email)
            binding.inputLayoutEmailLoginMain.error = valid.checkPassword(password)
            if (binding.inputLayoutEmailLoginMain.error == null &&
                binding.inputLayoutPasswordLoginMain.error == null
            ) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", email)
                startActivity(intent)
            }
        }
        binding.textViewSignUpMain.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
