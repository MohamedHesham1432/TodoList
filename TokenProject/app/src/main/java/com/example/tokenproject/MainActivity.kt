package com.example.tokenproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tokenproject.data.model.LoginRequest
import com.example.tokenproject.ui.theme.TokenProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()


        setContent {
            val loginViewModel = remember{MianVeiwModel()}
            val usename=remember{mutableStateOf("")}
            val password=remember{mutableStateOf("")}
            loginViewModel.Loginrequest(loginRequest = LoginRequest(20,"",""))
            TokenProjectTheme {
                Column(modifier = Modifier.padding(16.dp).fillMaxSize().fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(value = usename.value, onValueChange ={
                        usename.value=it
                    } )
                    OutlinedTextField(value =password.value , onValueChange ={
                        password.value=it
                    } )
                    Button(onClick = {
                        loginViewModel.Loginrequest(loginRequest = LoginRequest(20,password.value,usename.value))
                    }, colors = ButtonDefaults.buttonColors(Color.Blue)) {
                        Text(text = "Login",color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TokenProjectTheme {
        Greeting("Android")
    }
}