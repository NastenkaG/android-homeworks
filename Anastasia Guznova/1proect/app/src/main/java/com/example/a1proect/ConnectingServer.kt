package com.example.a1proect

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://megarick-todo-app.herokuapp.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ServerApi::class.java)
}