package com.example.a1proect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a1proect.databinding.ActivityMainBinding
import com.example.a1proect.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    val valid = validation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regButton.setOnClickListener {
            val pass1 = binding.textPassword1.text.toString()
            val pass2 = binding.textPassword2.text.toString()
            val email = binding.textEmailRegistr.text.toString()

            when{
                valid.validEmail1(email) -> binding.textEmailRegistr.error = getString(R.string.validEmail1)
                valid.validEmail2(email) -> binding.textEmailRegistr.error = getString(R.string.validEmail2)
                valid.validPassword(pass1) -> binding.textPassword1.error = getString(R.string.validPass)
                valid.validPasswordRegistr(pass1, pass2) -> binding.textPassword2.error = getString(R.string.validPass2)
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("Name", email)
                    startActivity(intent)}
            }
        }

        binding.Registration.setOnClickListener {
            val pass11 = binding.textPassword1.text.toString()
            val pass22 = binding.textPassword2.text.toString()
            val email1 = binding.textEmailRegistr.text.toString()

            when{
                valid.validEmail1(email1) -> binding.textEmailRegistr.error = getString(R.string.validEmail1)
                valid.validEmail2(email1) -> binding.textEmailRegistr.error = getString(R.string.validEmail2)
                valid.validPassword(pass11) -> binding.textPassword1.error = getString(R.string.validPass)
                valid.validPasswordRegistr(pass11, pass22) -> binding.textPassword2.error = getString(R.string.validPass2)
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)}
            }

        }
    }
}