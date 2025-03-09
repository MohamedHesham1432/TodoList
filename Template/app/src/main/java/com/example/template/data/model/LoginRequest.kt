package com.example.template.data.model

data class LoginRequest(
    val username:String,
    val password:String,
    val expireInMin:Int
)
