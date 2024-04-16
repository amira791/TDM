package com.example.navifationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navifationexample.ui.theme.Destination
import com.example.navifationexample.ui.theme.NavifationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavifationExampleTheme {
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
}



@Composable
fun NavigationExample(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable(Destination.Ecran1.route) { DisplayEcran1(navController = navController) }
        composable(Destination.Ecran2.route) { DisplayEcran2(navHostController = navController) }
        composable(Destination.Ecran3.route) { DisplayEcran3(navHostController = navController) }
    }
}





