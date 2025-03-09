package com.example.sakaniapp.persentation.Ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.sakaniapp.R

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val username= remember { mutableStateOf("") }
        val password= remember { mutableStateOf("") }
        val navigator= LocalNavigator.currentOrThrow

        Image(painter = painterResource(id = R.drawable.intro_screen),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
            contentDescription =null,
            )
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            //username textfield
            OutlinedTextField(value =username.value ,
                onValueChange ={username.value = it},
                label={ Text(text = "username")},

            )
            
            //to make a space between the textfields
            Spacer(modifier = Modifier.height(16.dp))
            
            //password textfield
            OutlinedTextField(value =password.value ,
                onValueChange ={password.value = it},
                label={ Text(text = "username")}
            )
            
            //button for signin
            Button(onClick = {navigator.push(HomeScreen())}) {
                Text(text = "Sign In")
            }
        }
    }
}