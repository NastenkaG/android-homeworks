package com.example.a1proect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a1proect.databinding.ActivityMainBinding
import com.example.a1proect.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    val prov = proverka()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
            val pass1 = binding.textPassword1.text.toString()
            val pass2 = binding.textPassword2.text.toString()
            val email = binding.textEmailRegistr.text.toString()

            when{
                prov.provEmail1(email) -> binding.textEmailRegistr.error = "Введите настоящую почту"
                prov.provEmail2(email) -> binding.textEmailRegistr.error = "Введите почту хорошей длины"
                prov.provPassword(pass1) -> binding.textPassword1.error = "Проверьте длину пароля"
                prov.provPasswordRegistr(pass1, pass2) -> binding.textPassword2.error = "Пароли не совпадают"
                else -> {
                    Toast.makeText(this, "Все хорошо", Toast.LENGTH_SHORT).show()
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
                prov.provEmail1(email1) -> binding.textEmailRegistr.error = "Введите настоящую почту"
                prov.provEmail2(email1) -> binding.textEmailRegistr.error = "Введите почту хорошей длины"
                prov.provPassword(pass11) -> binding.textPassword1.error = "Проверьте длину пароля"
                prov.provPasswordRegistr(pass11, pass22) -> binding.textPassword2.error = "Пароли не совпадают"
                else -> {
                    Toast.makeText(this, "Все хорошо", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)}
            }

        }
    }
}