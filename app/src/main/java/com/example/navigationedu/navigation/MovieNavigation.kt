package com.example.navigationedu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationedu.screens.detail.DetailScreen
import com.example.navigationedu.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HOMESCREEN.name
    ) {
        composable(route = MovieScreens.HOMESCREEN.name){
            HomeScreen(navController = navController)
        }

        composable(
            route = MovieScreens.DETAILSCREEN.name+"/{movie}",
            arguments = listOf(navArgument("movie"){type = NavType.StringType})
        ){
            DetailScreen(navController = navController, it.arguments?.getString("movie"))
        }
    }
}