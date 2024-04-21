package com.example.tp05

import AuthViewModel
import DisplayProfile

import LoginScreen
import ParkList
import ResList
import SharedPreferencesManager
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navifationexample.ui.theme.Destination
import com.example.tp05.ui.theme.TP05Theme
import com.siviwe.composeapp.data.Parkings
import com.siviwe.composeapp.data.Reservations


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP05Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    Go(navController = rememberNavController())

                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Go (navController: NavHostController) {
    val context = LocalContext.current
    val currentindex =navController.currentBackStackEntryAsState().value?.destination?.route


    val sh = SharedPreferencesManager(context)
    val isLoggedIn = sh.isLoggedIn()



    val reservs = Reservations.MyRerv
    val parks = Parkings.MyPark



    val navigateToLogin: () -> Unit = {
        navController.navigate(Destination.Ecran4.route)
    }
    val authViewModel = remember {
        AuthViewModel(
            sharedPreferencesManager = SharedPreferencesManager(context )
        )
    }


    Scaffold(

        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                NavigationBar {
                    NavigationBarItem(label={ Text(text = "Home")},
                        selected = currentindex== Destination.Ecran2.route, onClick = { navController.navigate(
                            Destination.Ecran2.route) }, //home
                        icon = {Icon(Icons.Default.Home,contentDescription = "Ecran1") })
                    NavigationBarItem(label={ Text(text = "MyResv")},
                        selected = currentindex == Destination.Ecran1.route,
                        onClick = { navController.navigate(Destination.Ecran1.route) },
                        icon = { Icon(Icons.Default.Favorite,contentDescription = "Ecran1") })
                    NavigationBarItem(label={ Text(text = "Profile")},selected = currentindex== Destination.Ecran3.route,
                        onClick = { navController.navigate(Destination.Ecran3.route) },
                        icon = { Icon(Icons.Default.AccountBox,contentDescription = "Ecran1") })
                }

            }
        },

        ) {
        NavHost(navController = navController, startDestination = Destination.Ecran2.route) {
            composable(Destination.Ecran2.route) { ParkList(parks) }
            composable(Destination.Ecran3.route) { DisplayProfile(navController) }
            composable(Destination.Ecran1.route) {
                ResList(reservations = reservs, isLoggedIn = isLoggedIn, navHostController = navController, viewModel = authViewModel)
            }
            composable(Destination.Ecran4.route) {
                LoginScreen( authViewModel, navController)
            }
        }




    }

    }

