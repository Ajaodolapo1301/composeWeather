package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.screens.MainScreen
import com.example.weatherapp.screens.SplashScreen
import com.example.weatherapp.screens.about.AboutPage
import com.example.weatherapp.screens.main.MainViewModel

@Composable
fun AppNavigation (){
    var navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.SPLASHSCREEN.name, ){
        composable(route = AppScreens.SPLASHSCREEN.name){
            SplashScreen(navController = navigationController)
        }


        composable(route = AppScreens.MainScreen.name) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navigationController,
                    viewModel= viewModel
            )
        }

        composable(route = AppScreens.AboutScreen.name) {
//            val viewModel = hiltViewModel<MainViewModel>()
            AboutPage(navController = navigationController,
//                viewModel= viewModel
            )
        }


    }
}