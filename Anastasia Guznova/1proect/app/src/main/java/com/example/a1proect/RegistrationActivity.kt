package com.example.a1proect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a1proect.databinding.ActivityMainBinding
import com.example.a1proect.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    val valid = Validation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regButton.setOnClickListener {
            val password = binding.textPassword1.text.toString()
            val repeatedPassword = binding.textPassword2.text.toString()
            val email = binding.textEmailRegistration.text.toString()
            when {
                valid.validateEmail(email) -> binding.textEmailRegistration.error = getString(R.string.validEmail1)
                valid.validatePassword(password) -> binding.textPassword1.error = getString(R.string.validPass)
                valid.validatePasswordRegistration(password, repeatedPassword) -> binding.textPassword2.error = getString(R.string.validPass2)
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("Name", email)
                    startActivity(intent)
                }
            }
        }
        binding.regSignUp.setOnClickListener {
            val password2 = binding.textPassword1.text.toString()
            val repeatedPassword2 = binding.textPassword2.text.toString()
            val email2 = binding.textEmailRegistration.text.toString()
            when {
                valid.validateEmail(email2) -> binding.textEmailRegistration.error = getString(R.string.validEmail1)
                valid.validatePassword(password2) -> binding.textPassword1.error = getString(R.string.validPass)
                valid.validatePasswordRegistration(password2, repeatedPassword2) -> binding.textPassword2.error = getString(R.string.validPass2)
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
