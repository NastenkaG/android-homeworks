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
            val valid = Validator()
            val password = binding.textPasswordEnter.text.toString()
            val repeatedPassword = binding.textPasswordConfirm.text.toString()
            val email = binding.textEmailRegistration.text.toString()
            when {
                valid.validateEmail(email) ->
                    binding.textEmailRegistration.error = getString(R.string.error_email)
                valid.validatePassword(password) ->
                    binding.textPasswordEnter.error = getString(R.string.error_password)
                valid.validateIdenticalPassword(password, repeatedPassword) ->
                    binding.textPasswordConfirm.error = getString(R.string.error_coincidence_password)
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("Name", email)
                    startActivity(intent)
                }
            }
        }
        binding.regSignUpClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
