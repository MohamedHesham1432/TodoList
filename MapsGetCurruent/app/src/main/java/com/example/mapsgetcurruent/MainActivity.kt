package com.example.mapsgetcurruent

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.example.mapsgetcurruent.ui.theme.MapsGetCurruentTheme
import com.google.android.gms.location.LocationServices
import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.FusedLocationProviderClient


class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        //enableEdgeToEdge()
        setContent {

            MapsGetCurruentTheme {
                var location by remember { mutableStateOf<Location?>(null) }
                var permissionGranted by remember { mutableStateOf(false) }
                val context: Context = LocalContext.current
                Text(
                    text = if (permissionGranted) {
                        location?.let {
                            "latitude: ${it.latitude}, longitude: ${it.longitude}"
                        }?:"Fetching location..."
                    }
                    else{
                        "Permission not granted"
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                if (!permissionGranted){
                    Button(onClick = {

                        //request peresmission
                        //inside main activity
                        requestPermissions(arrayOf
                            (Manifest.permission.ACCESS_FINE_LOCATION),
                            1)
                    }) {
                        Text(text = "Request location")

                    }

                    LaunchedEffect(Unit) {
                            // Check permission
                            permissionGranted = ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            ) == PackageManager.PERMISSION_GRANTED
                        // get location
                        if(permissionGranted) {
                            fusedLocationClient.lastLocation.addOnSuccessListener { loc ->
                                location=loc
                            }
                        }

                    }
                }

        }
    }
}
}
