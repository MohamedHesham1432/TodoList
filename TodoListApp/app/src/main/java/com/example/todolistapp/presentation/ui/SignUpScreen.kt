package com.example.todolistapp.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.todolistapp.R
import com.example.todolistapp.presentation.ui.LoginScreen

class SignUpScreen : Screen {
    @Composable
    override fun Content() {
        signupscreen()
    }

    @Composable
    fun signupscreen(){
        val name= remember { mutableStateOf("") }
        val email= remember { mutableStateOf("") }
        val password= remember { mutableStateOf("") }
        val navigator= LocalNavigator.currentOrThrow


        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Create Account",
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 50.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Let's Create Account Together",
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_bk)),
                fontSize = 16.sp,
                color = Color(0xff707B81)
            )
            Spacer(modifier = Modifier.height(50.dp))





            Text(text = "Your Name", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                fontSize = 16.sp,
            )

            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(
                    value =name.value ,
                    onValueChange ={name.value=it},
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
            Spacer(modifier = Modifier.height(30.dp))





            Text(text = "Email Address", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                fontSize = 16.sp,
            )

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
            Spacer(modifier = Modifier.height(30.dp))




            Text(text = "Password", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
                fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                fontSize = 16.sp,
            )

            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(
                    value =password.value ,
                    onValueChange ={password.value=it},
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

            Spacer(modifier = Modifier.height(30.dp))


            //Adding comment
            Button(onClick = { navigator.push(TodoListPage()) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .height(54.dp)
                    .width(335.dp)
            )
            {
                Text(text = "Sign Up", fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                    fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .height(54.dp)
                    .width(335.dp)

            ) {
                Image(painter = painterResource(id = R.drawable.google),
                    contentDescription =null,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end = 5.dp))
                Text(
                    text = "Sign Up With Google",
                    fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),

                    fontSize = 18.sp,
                )

            }
            Spacer(modifier = Modifier.height(130.dp))

            Row {
                Text(text = "Already have an account?")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Sign in",
                    fontFamily = FontFamily(Font(resId = R.font.airbnbcereal_w_md)),
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .clickable { navigator.push(LoginScreen())},
                    color = Color.DarkGray,)
            }
        }
    }
}