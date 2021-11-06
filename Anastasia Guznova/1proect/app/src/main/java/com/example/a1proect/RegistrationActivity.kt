package com.example.a1proect

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a1proect.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regButton.setOnClickListener {
            val valid = Validator(this)
            val password = binding.textPasswordEnter.text.toString()
            val repeatedPassword = binding.textPasswordConfirm.text.toString()
            val email = binding.textEmailRegistration.text.toString()
            binding.textEmailRegistration.error = valid.validateEmail(email)
            binding.textPasswordEnter.error = valid.validatePassword(password)
            binding.textPasswordConfirm.error =
                valid.validateIdenticalPassword(password, repeatedPassword)
            if (valid.validateEmail(email) == null && valid.validatePassword(password) == null &&
                valid.validateIdenticalPassword(password, repeatedPassword) == null) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Name", email)
                startActivity(intent)
            }
        }
        binding.regSignUpClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
