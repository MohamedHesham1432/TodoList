package com.example.template.data.model

data class RefreshTokenRequest(
    val refreshToken: String,
    val expireInMin: Int
)
