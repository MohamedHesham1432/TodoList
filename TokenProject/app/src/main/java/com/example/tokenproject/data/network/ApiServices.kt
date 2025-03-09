package com.example.tokenproject.data.network

import com.example.tokenproject.data.model.LoginRequest
import com.example.tokenproject.data.model.user
import com.example.tokenproject.interceptor.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @POST("login")

    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginRequest>

    @GET("me")
    suspend fun getUser(): Response<user>
}
object RetrtofitInstance{

    val authinterceptor = AuthInterceptor()

    // Create a logging interceptor
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Logs the request and response body
    }

    // Create an OkHttpClient and add the logging interceptor
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authinterceptor)
        .build()



    val retrofit = Retrofit.Builder()
//        .baseUrl("https://newsapi.org/v2/")
        .baseUrl("https://dummyjson.com/auth/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiClient = retrofit.create(ApiServices::class.java)
fun setToken(token:String){
    authinterceptor.setToken(token)
}

}
