package com.example.navigation

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object Profile: Destination ("profile")
    object Details: Destination ("details/{userId}")
    {
        fun createRoute (userId:Int) = "details/$userId"
    }
}