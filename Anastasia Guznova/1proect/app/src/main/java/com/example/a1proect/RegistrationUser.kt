package com.example.a1proect

import com.google.gson.annotations.SerializedName

data class RegistrationUser(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("display_name")
	val displayName: String,

	@field:SerializedName("email")
	val email: String
)
