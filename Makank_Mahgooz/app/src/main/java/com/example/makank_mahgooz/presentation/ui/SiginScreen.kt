package com.example.makank_mahgooz.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.makank_mahgooz.R

class SiginScreen : Screen{
    @Composable
    override fun Content() {
        loginScreen()
    }

    @Preview (showBackground = true)
    @Composable
    fun loginScreen(){
        Box {
            Text(text = "Login", style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
            ),
                )
        }
    }
}