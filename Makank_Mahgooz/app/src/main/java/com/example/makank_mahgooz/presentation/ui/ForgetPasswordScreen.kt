package com.example.makank_mahgooz.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class ForgetPasswordScreen: Screen {
    @Composable
    override fun Content() {
        forgetPasswordScreen()
    }

    @Composable
    fun forgetPasswordScreen(){
        Text(text = "Forget Password")
    }

}