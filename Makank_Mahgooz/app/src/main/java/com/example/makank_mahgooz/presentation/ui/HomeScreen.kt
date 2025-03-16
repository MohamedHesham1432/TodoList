package com.example.makank_mahgooz.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        homescreen()
    }
    @Composable
    fun homescreen(){
        Text(text = "Home")
    }
}