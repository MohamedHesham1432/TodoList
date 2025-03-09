package com.example.loginproject.data.model

data class LoginRequest(
    val expiresInMins: Int,
    val password: String,
    val username: String
)