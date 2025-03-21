package com.example.makank_mahgooz.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.makank_mahgooz.R

class LoginScreen : Screen{
    @Composable
    override fun Content() {
        loginScreen()
    }

    @Preview (showBackground = true)
    @Composable
    fun loginScreen(){
        val navigator= LocalNavigator.currentOrThrow
        var email by remember { mutableStateOf("")}
        var password by remember { mutableStateOf("")}
        var isAgreed by remember { mutableStateOf(false) }
        Column(modifier = Modifier.padding(start = 16.dp, top = 75.dp)) {
            Text(text = "Login", style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
            ),)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Welcome back you’ve\n" +"been missed!",
                style = TextStyle(
                color = Color.Black.copy(alpha = 0.25f),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    )
            )
            Spacer(modifier = Modifier.height(33.dp))
            //email text field
            Text(text = "Email")
            OutlinedTextField(value =email ,
                onValueChange = {email = it},
                label = { Text(text = "Enter Your Email",
                    color =Color(0xffA7AFB6) )},
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.mail),
                    contentDescription = null,
                    tint = Color(0xffA7AFB6),
                    modifier = Modifier.size(20.dp)) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xff004AAD),
                    unfocusedBorderColor = Color(0xff004AAD)
                ),
                modifier = Modifier.width(329.dp)
                )
            Spacer(modifier = Modifier.height(15.dp))

            //password text field
            Text(text = "password")
            OutlinedTextField(value =password ,
                onValueChange = {password = it},
                label = { Text(text = "password",
                    color =Color(0xffA7AFB6))},
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.password),
                    contentDescription = null,
                    tint = Color(0xffA7AFB6),
                    modifier = Modifier.size(20.dp)) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xff004AAD),
                    unfocusedBorderColor = Color(0xff004AAD)
                ),
                modifier = Modifier.width(329.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            //remember me and forget password
            Row {
                Checkbox(checked = isAgreed, onCheckedChange = {isAgreed=it}, colors = CheckboxDefaults.colors(
                    checkedColor = Color.Black,
                    uncheckedColor = Color.Black,
                    checkmarkColor = Color.White
                ), modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Remember me",style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                ))
                Spacer(modifier = Modifier.width(56.dp))
                Text(text = "Forgot password?",style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                ),
                    modifier = Modifier.clickable(onClick = {navigator.push(ForgetPasswordScreen())}))
            }
            Spacer(modifier = Modifier.height(30.dp))
            // login button
            Button(onClick = {navigator.push(HomeScreen())},colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff004AAD),
                contentColor = Color.White
            ), shape = RoundedCornerShape(0.dp), modifier = Modifier
                .width(329.dp)
                .height(50.dp))
            {
                Text(text = "Login",style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                ))
            }
            Spacer(modifier = Modifier.height(38.dp))
            // or continue with
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(0.5f)
                        .height(1.dp),
                    color = Color.Gray
                )
                Text(
                    text = "or continue with",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(0.5f)
                        .height(1.dp),
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            // Login with google and facebook
            Row(modifier = Modifier.padding(start = 14.5.dp)) {
                OutlinedButton(onClick = {},modifier = Modifier
                    .width(145.dp)
                    .height(41.dp)) {
                    Icon(painter = painterResource(id =R.drawable.google ), contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(25.dp))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Google",
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            fontSize = 14.sp,
                        )
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedButton(onClick = {}, modifier = Modifier
                    .width(145.dp)
                    .height(41.dp)) {
                    Icon(painter = painterResource(id =R.drawable.facebook ), contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "facebook",
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            fontSize = 14.sp,
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(71.dp))
            Row(modifier = Modifier.padding(start = 52.dp)) {
                Text(text = "Don’t have an account?",style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                ))
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Sign up",style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color(0xff004AAD),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                ),
                    modifier = Modifier.clickable(onClick = {navigator.push(SignUpScreen())})
                )
            }
        }
    }
}