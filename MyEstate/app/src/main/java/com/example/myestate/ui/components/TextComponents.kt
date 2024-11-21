package com.example.myestate.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

object TextComponents {

    // HeadlineTitle
    @Composable
    fun HeadlineTitle(
        title:String,
        color:Color = Color.White,
        ){
        Text(
            title,
            color = color ,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold
        )
    }

    // SubTitle
    @Composable
    fun SubTitle(
        title:String,
        color:Color = Color.White,
        ) {
        Text(
            title,
            color = color,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )
    }


    // SubTitle
    @Composable
    fun NormalText(
        title:String,
        color:Color = Color.White,
    ) {
        Text(
            title,
            color = color,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
    }

}