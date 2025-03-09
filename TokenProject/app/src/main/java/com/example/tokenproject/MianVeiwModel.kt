package com.example.tokenproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tokenproject.data.model.LoginRequest
import com.example.tokenproject.data.model.user
import com.example.tokenproject.data.network.RetrtofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MianVeiwModel: ViewModel() {
    private val _LoginRequest= MutableStateFlow<LoginRequest?>(null)
    val LoginRequest: StateFlow<LoginRequest?>
        get() = _LoginRequest
    private val _UserResponse= MutableStateFlow<user?>(null)
    val UserResponse: StateFlow<user?>
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
                _LoginRequest.value=response.body()
            }
        }
    }
}
