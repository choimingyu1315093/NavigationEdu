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
fun BookNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BookScreens.HOMESCREEN.name
    ) {
        composable(route = BookScreens.HOMESCREEN.name){
            HomeScreen(navController = navController)
        }

        composable(
            route = BookScreens.DETAILSCREEN.name+"/{book}",
            arguments = listOf(navArgument("book"){type = NavType.StringType})
        ){

            DetailScreen(navController = navController, it.arguments?.getString("book"))
        }
    }
}