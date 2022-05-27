package com.example.a1proect

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a1proect.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logButton.setOnClickListener {
            val preferenceManager = PreferenceManager(this)
            val valid = Validator(this)
            val password = binding.logTextInputEditPassword.text.toString()
            val email = binding.logTextInputEditEmail.text.toString()
            binding.logTextInputEmail.error = valid.validateEmail(email)
            binding.logTextInputPassword.error = valid.validatePassword(password)
            if (binding.logTextInputEmail.error.isNullOrBlank() &&
                binding.logTextInputPassword.error.isNullOrBlank()
            ) {

                ApiService.retrofit.loginUser(LoginUser(password, email))
                    .enqueue(object : Callback<Token> {
                        override fun onResponse(call: Call<Token>, response: Response<Token>) {
                            if (response.isSuccessful) {
                                preferenceManager.writeToPreferencesEmail(email)
                                preferenceManager.writeToPreferencesToken(
                                    response.body()?.token.toString()
                                )
                                val intent = Intent(
                                    this@MainActivity,
                                    HomeActivity::class.java
                                )
                                intent.putExtra("Name", email)
                                startActivity(intent)
                            } else {
                                when (response.code()) {
                                    400 -> Toast.makeText(
                                        this@MainActivity, "Проблемы при входе в аккаунт",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    401 -> Toast.makeText(
                                        this@MainActivity, "Некорректные данные входа",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<Token>, t: Throwable) {
                            Toast.makeText(
                                this@MainActivity, "Error",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                }
            }

        binding.singUpRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
