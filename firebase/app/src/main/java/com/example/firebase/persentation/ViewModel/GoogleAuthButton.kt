package com.example.firebase.persentation.ViewModel



import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import cafe.adriel.voyager.core.screen.Screen
import com.example.firebase.R
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import kotlinx.coroutines.launch

class GoogleAuthButton{

    @Composable
    fun AuthenticationButton(buttonText: Int, onGetCredentialResponse:(Credential) -> Unit) {
        val context= LocalContext.current
        val coroutineScope= rememberCoroutineScope()
        val credentialManager= CredentialManager.create(context)

        //button to login with google
        OutlinedButton(onClick = {
            val googleidoption= GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(context.getString(R.string.Web_Clint_Id))
                .build()
            val request= GetCredentialRequest.Builder()
                .addCredentialOption(googleidoption)
                .build()

            coroutineScope.launch {
                try{
                    val result=credentialManager.getCredential(
                        request = request,
                        context = context
                    )
                    onGetCredentialResponse(result.credential)
                }
                catch (e:Exception){
                    Log.d("error",e.message.toString())
                }

            }

        }) {
            Image(painter = painterResource(id = R.drawable.Google), contentDescription =null )
            Text(text = "Login With google")
        }
    }
}