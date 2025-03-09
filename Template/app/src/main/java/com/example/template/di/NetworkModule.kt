package com.example.template.di

import com.example.template.data.network.ApiService
import com.example.tokenproject.interceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit(authInterceptor: AuthInterceptor): Retrofit {
        // Create a logging interceptor
         val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Logs the request and response body
        }

        // Create an OkHttpClient and add the logging interceptor
         val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
             .addInterceptor(authInterceptor)
            .build()



        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    // to add token to every request
    @Provides
    @Singleton
    fun provideapiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    // to add token to every request
    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }
}