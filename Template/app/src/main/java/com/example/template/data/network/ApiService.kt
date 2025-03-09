package com.example.template.data.network

import com.example.template.data.model.LoginResponse
import com.example.template.data.model.LoginRequest
import com.example.template.data.model.RefreshTokenRequest
import com.example.template.data.model.RefreshTokenResponse
import com.example.template.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    //implement login
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("auth/me")
    suspend fun getcurrentuser(): Response<UserResponse>

    @POST("auth/refresh")
    suspend fun refreshtoken(@Body refreshTokenRequest: RefreshTokenRequest): Response<RefreshTokenResponse>
}