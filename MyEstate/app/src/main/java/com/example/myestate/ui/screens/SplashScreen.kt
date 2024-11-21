package com.example.myestate.ui.screens

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.R
import com.example.myestate.ui.components.ButtonComponents
import com.example.myestate.ui.components.TextComponents

@Composable
fun SplashScreen() {
    Box {

        Image(
            painterResource(R.drawable.testbackimage),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
          )

        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
            ) {
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                TextComponents.HeadlineTitle("My Estate")
                TextComponents.SubTitle("Reach The Life of Your Dreams")
            }

            Column(modifier = Modifier.padding(bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Email Button
                ButtonComponents.AccountButton(
                    "Email",
                    backColor = Color.Black,
                    textColor = Color.White
                    )
                // Google Button
                ButtonComponents.AccountButton(
                    "Google",
                    backColor = Color.Red,
                    textColor = Color.White)

                TextComponents.NormalText("continue without membership")

            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}