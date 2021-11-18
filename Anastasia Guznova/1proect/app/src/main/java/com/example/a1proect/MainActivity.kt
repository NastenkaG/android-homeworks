package com.example.a1proect

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a1proect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logButton.setOnClickListener {
            val valid = Validator(this)
            val password = binding.logTextInputEditPassword.text.toString()
            val email = binding.logTextInputEditEmail.text.toString()
            binding.logTextInputEmail.error = valid.validateEmail(email)
            binding.logTextInputPassword.error = valid.validatePassword(password)
            if (binding.logTextInputEmail.error.isNullOrBlank() &&
                binding.logTextInputPassword.error.isNullOrBlank()
            ) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Name", email)
                startActivity(intent)
            }
        }
        binding.singUpRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
