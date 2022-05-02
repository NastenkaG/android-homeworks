package com.example.za

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.za.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.ButtonRegistration.setOnClickListener {
            val valid = Validator(this)
            val email = binding.editTextEmailRegistration.text.toString()
            val password = binding.editTextConfirmPasswordRegistration.text.toString()
            val username = binding.editTextNameRegistration.text.toString()
            val confimPassword = binding.editTextConfirmPasswordRegistration.text.toString()

            binding.inputLayoutEmailRegistration.error = valid.checkEmail(email)
            binding.inputLayoutPasswordRegistration.error = valid.checkPassword(password)
            binding.inputLayoutConfirmPasswordRegistration.error =
                valid.confirmPassword(password, confimPassword)
            binding.inputLayoutNameRegistration.error = valid.checkName(username)
            if (binding.inputLayoutPasswordRegistration.error == null &&
                binding.inputLayoutEmailRegistration.error == null &&
                binding.inputLayoutConfirmPasswordRegistration.error == null &&
                binding.inputLayoutNameRegistration.error == null
            ) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", email)
                startActivity(intent)
            }
        }
        binding.textViewSingInRegister.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
