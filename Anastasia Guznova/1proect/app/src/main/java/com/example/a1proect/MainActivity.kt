package com.example.a1proect


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a1proect.databinding.ActivityMainBinding
import  com.google.android.material.button.MaterialButton
import android.content.Intent;

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val prov = proverka()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val email = binding.textInputEditText1.text.toString()
            val password = binding.textInputEditText2.text.toString()

            when{
                prov.provEmail1(email) -> binding.textInputEditText1.error = "Введите настоящую почту"
                prov.provEmail2(email) -> binding.textInputEditText1.error = "Введите почту хорошей длины"
                prov.provPassword(password) -> binding.textInputEditText2.error = "Проверьте длину пароля"
                else -> {Toast.makeText(this, "Все хорошо", Toast.LENGTH_SHORT).show()
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



