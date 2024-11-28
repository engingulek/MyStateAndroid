package com.example.myestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.myestate.ui.navigation.AppNavigation
import com.example.myestate.ui.theme.MyEstateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyEstateTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    AppNavigation(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding),
                        navHostController = navController
                    )
                }
            }
        }
    }
}

