package com.example.networking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.networking.ui.theme.NetworkingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {/*
            val viewModel = remember { MainVeiwModel() }
            viewModel.getNews()
            val news=viewModel.newsRespone.collectAsState()
*/

            val viewModel = remember { MainVeiwModel() }
            viewModel.getNews()
            val game=viewModel.gameRespone.collectAsState()

            NetworkingTheme{
                Column(modifier = Modifier.padding(16.dp).fillMaxSize().fillMaxWidth()) {
                    LazyColumn {
                        items(game.value?: emptyList()){
                            Card(modifier = Modifier.padding(8.dp)) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    AsyncImage(model = it.thumbnail, contentDescription = null)
                                    Text(text = it.genre?:"")
                                    Text(text = it.title?:"")
                                    Text(text = it.platform?:"")
                                }
                            }
                        }
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
    NetworkingTheme {
        Greeting("Android")
    }
}