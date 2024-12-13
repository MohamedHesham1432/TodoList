package com.example.todolistapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.todolistapp.R

class ForgetPasswordScreen :Screen {
    @Composable
    override fun Content() {
        forgetpasswordscreen()
    }
    @Composable
    fun forgetpasswordscreen(){
        val email= remember { mutableStateOf("") }
        val navigator= LocalNavigator.currentOrThrow
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Recovery Password",
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                fontSize = 24.sp,
                modifier = Modifier.padding(end = 4.dp)
            )


            Spacer(
                modifier = Modifier.heightIn(4.dp)
            )


            Text(text = "Please Enter Your Email Address To Receive a Verification Code",
                modifier = Modifier.padding(start = 57.dp, end = 57.dp),
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_bk)),
                fontSize = 16.sp,
                color = Color(0xff707B81)

            )
            
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Email Address", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(
                    value =email.value ,
                    onValueChange ={email.value=it},
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .width(335.dp)
                        .height(48.dp)
                        .padding(start = 20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.DarkGray,
                        unfocusedTextColor = Color.DarkGray,
                        focusedBorderColor = Color.DarkGray,
                        unfocusedBorderColor = Color.DarkGray,
                    )
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { navigator.push(LoginScreen()) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .height(54.dp)
                    .width(335.dp)
            )
            {
                Text(text = "Continue", fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                    fontSize = 18.sp)
            }
        }
    }
}