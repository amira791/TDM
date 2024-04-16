package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigation.ui.theme.NavigationTheme
import androidx.navigation.compose.rememberNavController



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationExample(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun NavigationExample (navController: NavHostController)
{
    NavHost (navController = navController, startDestination = "home")
    {
        composable (Destination.Home.route ) { DisplayHome (navController)}
        composable ("profile") {DisplayProfile(navController)}
        composable ("details/{userId}") {
            val userId = it.arguments?.getString("userId")?.toInt()
            DisplayDetails (userId)
        }
    }
}