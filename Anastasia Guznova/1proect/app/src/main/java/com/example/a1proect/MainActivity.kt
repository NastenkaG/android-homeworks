package com.example.a1proect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a1proect.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logButton.setOnClickListener {
            val valid = Validation()
            val email = binding.logTextInputEditEmail.text.toString()
            val password = binding.logTextInputEditPassword.text.toString()
            when {
                valid.validateEmail(email) ->
                    binding.logTextInputEditEmail.error = getString(R.string.validEmail1)
                valid.validatePassword(password) ->
                    binding.logTextInputEditPassword.error = getString(R.string.validPass)
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("Name", email)
                    startActivity(intent)}
            }
        }
        binding.singUpRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}



