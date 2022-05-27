package com.example.a1proect

import com.google.gson.annotations.SerializedName

data class LoginUser(

@field:SerializedName("password")
val password: String,

@field:SerializedName("email")
val email: String

)
