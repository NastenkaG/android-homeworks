package com.example.a1proect

import retrofit2.Call
import retrofit2.http.*

interface ServerApi {
    @POST("user/create")
    fun registrationUser(
        @Body registrationUser: RegistrationUser
    ): Call<Token>

    @POST("user/login")
    fun loginUser(
        @Body loginUser: LoginUser
    ): Call<Token>

    @GET("todos")
    fun getTasks(
        @Header("Authorization") token: String
    ): Call<List<GettingTasks>>

    @POST("todos")
    fun putTask(
        @Body text: AddTask,
        @Header("Authorization") token: String
    ): Call<Unit>

    @PUT("todos/mark")
    fun changeTask(
        @Query("id") id: Int,
        @Header("Authorization") token: String
    ): Call<Unit>

    @DELETE("todos/{id}")
    fun deleteTask(
        @Path("id") id: Int,
        @Header("Authorization") token: String
    ): Call<Unit>
}