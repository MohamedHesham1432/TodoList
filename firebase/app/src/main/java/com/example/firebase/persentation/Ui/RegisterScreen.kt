package com.example.firebase.persentation.Ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.firebase.persentation.ViewModel.AuthViewModel

class RegisterScreen: Screen {
    @Composable
    override fun Content() {
        val Email= remember { mutableStateOf("") }
        val AuthViewModel= AuthViewModel()
        val navigator= LocalNavigator.currentOrThrow
        val password= remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(value = Email.value,
                onValueChange = { Email.value=it },
                label = { Text("Email") })

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = password.value,
                onValueChange = { password.value=it }
                ,label = { Text("Password") })

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { AuthViewModel.register(Email.value,password.value
                , onRegisterSuccess = {navigator.pop()}
                , onRegisterFailure = {})}
            ) {
                Text(text = "Register")
            }
            TextButton(onClick = { navigator.pop() }) {
                Text(text = "Already have an account? Login")
            }

        }
    }
}