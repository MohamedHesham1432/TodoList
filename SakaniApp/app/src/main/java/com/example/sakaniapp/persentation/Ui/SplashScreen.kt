package com.example.sakaniapp.persentation.Ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.core.screen.Screen
import com.example.sakaniapp.R

class SplashScreen : Screen {
    @Composable
    override fun Content() {

        Image(painter = painterResource(id = R.drawable.intro_screen),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)

            Image(painter = painterResource(id = R.drawable.main_logo),
                contentDescription =null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit,
                )
    }
}