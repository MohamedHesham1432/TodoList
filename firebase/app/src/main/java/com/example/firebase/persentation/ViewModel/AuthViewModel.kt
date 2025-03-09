package com.example.firebase.persentation.ViewModel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    

    fun login(Email: String, password: String, onLoginSuccess: () -> Unit, onLoginFailure: (String) -> Unit) {
        try {
            firebaseAuth.signInWithEmailAndPassword(Email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        onLoginSuccess()
                    }
                    else {
                        onLoginFailure(it.exception?.message ?: "Login failed")
                    }
                }
        }
        catch (e: Exception) {
            onLoginFailure(e.message ?: "Login failed")
        }
    }


    fun register (Email: String, password: String, onRegisterSuccess: () -> Unit, onRegisterFailure: (String) -> Unit){
        try {
            firebaseAuth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        onRegisterSuccess()
                    } else {
                        onRegisterFailure(it.exception?.message ?: "Register failed")
                    }
                }
        }
        catch (e: Exception){
            onRegisterFailure(e.message ?: "Register failed")
        }

    }
}