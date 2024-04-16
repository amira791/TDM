package com.example.navifationexample.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

sealed class Destination (val route: String) {
    object Ecran1: Destination("Ecran1")
    object Ecran2: Destination ("Ecran2")
    object Ecran3: Destination ("Ecran3")

    object Ecran4: Destination ("Ecran4")
    object Ecran5: Destination ("Ecran5")
    object Ecran6: Destination ("Ecran6")
    object Ecran7: Destination ("Ecran7")


}

@Composable
fun DisplayEcran1(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("This is the 1st Screen ")
        Button(
            onClick = { navController.navigate(Destination.Ecran1.route) }
        ) {
            Text("Ecran1")
        }
    }
}