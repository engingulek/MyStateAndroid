package com.example.myestate.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myestate.ui.screens.splash.SplashScreen

@Composable
fun HomeScreen() {
    Box {
        Text("Home Screen")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}