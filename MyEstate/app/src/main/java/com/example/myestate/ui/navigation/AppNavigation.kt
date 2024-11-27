package com.example.myestate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.myestate.ui.screens.detail.AdvertDetailScreen
import com.example.myestate.ui.screens.favorite.FavoriteScreen
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
            HomeScreen(
                navigateToDetail = { advertId ->
                    navHostController.navigate("advertDetailScreen/$advertId")
                },
                navigateTofFavorite = {navHostController.navigate("favoriteScreen")}
            )
        }

        composable(
            "advertDetailScreen/{advertId}",
            arguments = listOf(navArgument("advertId"){type = NavType.IntType})
        ){ backStackEntry ->
            val advertId = backStackEntry.arguments?.getInt("advertId")
            AdvertDetailScreen(advertId)
        }

        composable("favoriteScreen"){
            FavoriteScreen()
        }
    }
}