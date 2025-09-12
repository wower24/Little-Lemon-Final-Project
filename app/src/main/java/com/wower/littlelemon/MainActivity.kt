package com.wower.littlelemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wower.littlelemon.Home
import com.wower.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                val sharedPreferences = getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
                App(sharedPreferences.getBoolean("isLoggedIn", false))
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

@Composable
fun App(isLoggedIn : Boolean) {
    val navController: NavHostController = rememberNavController()
    Navigation(navController, false)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonTheme {
        Greeting("Android")
    }
}