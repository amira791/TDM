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
    object Ecran1: Destination("MyResv")
    object Ecran2: Destination ("Home")
    object Ecran3: Destination ("Profile")



}

