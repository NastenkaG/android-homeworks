package com.example.a1proect

import com.google.gson.annotations.SerializedName

data class GettingTasks(
@field:SerializedName("id")
val id: Int,

@field:SerializedName("text")
val text: String,

@field:SerializedName("isСompleted")
val isCompleted: Boolean,

@field:SerializedName("userId")
val userId: Int
)
