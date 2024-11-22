package com.example.myestate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.myestate.ui.screens.home.HomeScreen
import com.example.myestate.ui.screens.splash.SplashScreen
import com.example.myestate.ui.screens.splash.SplashScreenPreview

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    ) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "splashScreen"
    ){
        composable("splashScreen"){
            SplashScreen(
                navigateToHome = {navHostController.navigate("homeScreen")}
            )
        }

        composable("homeScreen"){
            HomeScreen()
        }
    }
}