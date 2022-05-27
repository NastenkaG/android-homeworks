package com.example.a1proect

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a1proect.databinding.ActivityRegistrationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regButton.setOnClickListener {
            val valid = Validator(this)
            val preferenceManager = PreferenceManager(this)
            val password = binding.textPasswordEnter.text.toString()
            val repeatedPassword = binding.textPasswordConfirm.text.toString()
            val email = binding.textEmailRegistration.text.toString()
            val name = binding.textFullNameRegistration.text.toString()
            binding.regTextInputName.error = valid.validateName(name)
            binding.regTextInputEmail.error = valid.validateEmail(email)
            binding.regTextInputPasswordEnter.error = valid.validatePassword(password)
            binding.regTextInputPasswordConfirm.error =
                valid.validateIdenticalPassword(password, repeatedPassword)
            if (binding.regTextInputEmail.error.isNullOrBlank() &&
                binding.regTextInputPasswordEnter.error.isNullOrBlank() &&
                binding.regTextInputPasswordConfirm.error.isNullOrBlank() &&
                binding.regTextInputName.error.isNullOrBlank()
            ) {
                ApiService.retrofit.registrationUser(
                    RegistrationUser(password, name, email)
                ).enqueue(object : Callback<Token>  {
                    override fun onResponse(call: Call<Token>, response: Response<Token>) {
                        if (response.isSuccessful) {
                            preferenceManager.writeToPreferencesToken(
                                response.body()?.token.toString()
                            )
                            preferenceManager.writeToPreferencesEmail(email)
                            val intent = Intent(
                                this@RegistrationActivity,
                                HomeActivity::class.java
                            )
                            Toast.makeText(this@RegistrationActivity, "ok", Toast.LENGTH_SHORT).show()
                            intent.putExtra("Name", email)
                            startActivity(intent)
//                            finish()
                        } else
                            Toast.makeText(
                                this@RegistrationActivity,
                                "Error",
                                Toast.LENGTH_LONG
                            ).show()
                    }
                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Toast.makeText(
                            this@RegistrationActivity,
                            t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } )
            }
        }
        binding.regSignUpClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


