package com.example.networking.data.network

import com.example.networking.data.model.GameResponse
import com.example.networking.data.model.NewsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
// code here
    /*
    @GET("everything")
    suspend fun getEveryThing(@Query("q") q : String, @Query("apiKey")apiKey : String):Response<NewsResponse>
*/
@GET("games")
    suspend fun getGames():Response<GameResponse>

}
object RetrtofitInstance{

    // Create a logging interceptor
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Logs the request and response body
    }

    // Create an OkHttpClient and add the logging interceptor
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()



    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.freetogame.com/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiClient = retrofit.create(ApiService::class.java)


}