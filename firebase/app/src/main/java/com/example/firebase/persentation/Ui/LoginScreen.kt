package com.example.firebase.persentation.Ui

import android.net.wifi.hotspot2.pps.Credential
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.firebase.R
import com.example.firebase.persentation.ViewModel.AuthViewModel
import com.example.firebase.persentation.ViewModel.GoogleAuthButton
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import kotlinx.coroutines.launch

class LoginScreen: Screen {

    @Composable
    override fun Content() {
        val Email= remember { mutableStateOf("") }
        val ViewModel :AuthViewModel= AuthViewModel()
        val navigator=LocalNavigator.currentOrThrow
        val password= remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxSize()) {

            OutlinedTextField(
                value = Email.value,
                onValueChange = { Email.value=it },
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password.value
                ,onValueChange = { password.value=it }
                ,label = { Text("Password") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { ViewModel.login(Email.value,password.value
                , onLoginSuccess = {navigator.push(HomeScreen())}
                , onLoginFailure = {/*handle failure*/})})
            {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(4.dp))

            GoogleAuthButton().AuthenticationButton(R.drawable.Google,{
                credential->
                ViewModel.onSignInWithGoogle(credential,openAndPopup)
            })

            Spacer(modifier = Modifier.height(4.dp))

            //text button to navigate to register screen
            TextButton(onClick = {navigator.push(RegisterScreen())})
            {
                Text(text = "Don't have an account? Register")
            }

        }
    }
}