package com.example.cenima_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cenima_app.ui.theme.Cenima_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login_screen")
            {
                composable("login_screen"){
                    login_screen()
                }
                composable("signup_screen"){
                    signup_screen()
                }

            }
        }
    }
}
@Composable
fun login_screen(){
    Column(modifier = Modifier
        .padding(10.dp)
        .background(color = Color.Yellow)
        .fillMaxSize()) {
      Text(text = "Login")
    }
}
@Composable
fun signup_screen(){
    Column(modifier = Modifier
        .padding(10.dp)
        .background(color = Color.Yellow)
        .fillMaxSize()) {
        Text(text = "Signup")
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
    Cenima_appTheme {
        Greeting("Android")
    }
}