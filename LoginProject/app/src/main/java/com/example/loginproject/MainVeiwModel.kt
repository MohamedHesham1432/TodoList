package com.example.loginproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginproject.data.model.LoginRequest
import com.example.loginproject.data.model.LoginResponse
import com.example.loginproject.data.model.User
import com.example.loginproject.data.networking.RetrtofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainVeiwModel:ViewModel() {


/*
    private val _LoginRequest= MutableStateFlow<LoginRequest?>(null)
    val LoginRequest: StateFlow<LoginRequest?>
        get() = _LoginRequest
*/

    private val _LoginResponse= MutableStateFlow<LoginResponse?>(null)
    val LoginResponse: StateFlow<LoginResponse?>
        get() = _LoginResponse



    private val _UserResponse= MutableStateFlow<User?>(null)
    val UserResponse: StateFlow<User?>
        get() = _UserResponse


    //val api= RetrtofitInstance.apiClient
    val api= RetrtofitInstance.apiClient


    fun getUser(){
        viewModelScope.launch {
            val response=api.getUser()
            if (response.isSuccessful){
                _UserResponse.value=response.body()
            }
            else{
                _UserResponse.value=null
            }
        }
    }


    fun Loginrequest(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=api.login(loginRequest)
            if (response.isSuccessful){
                _LoginResponse.value=response.body()
            RetrtofitInstance.setToken(response.body()?.token?:"")
                getUser()
                error("")
            }
            else {

            }
        }
    }
}