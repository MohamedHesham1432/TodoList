package com.example.networking

import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.example.networking.data.model.GameResponse
import com.example.networking.data.model.NewsResponse
import com.example.networking.data.network.RetrtofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainVeiwModel:ViewModel() {


    private val _gameRespone=MutableStateFlow<GameResponse?>(null)
    val gameRespone:StateFlow<GameResponse?>get() = _gameRespone


    //val api= RetrtofitInstance.apiClient
    val api= RetrtofitInstance.apiClient



fun getNews(){
    viewModelScope.launch {
        val response=api.getGames()
        if (response.isSuccessful){
            _gameRespone.value=response.body()
        }
    }
}
}