package com.example.myestate.ui.components
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

object TextComponents {

    // HeadlineTitle
    @Composable
    fun HeadlineTitle(
        title:String,
        color:Color = Color.White,
        modifier: Modifier = Modifier
        ){
        Text(
            title,
            color = color ,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier,
                    textAlign = TextAlign.Center
        )
    }

    // SubTitle
    @Composable
    fun SubTitle(
        title:String,
        color:Color = Color.White,
        modifier: Modifier = Modifier
        ) {
        Text(
            title,
            color = color,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier
        )
    }


    // NormalText
    @Composable
    fun NormalText(
        title:String,
        color:Color = Color.White,
        fontWeight: FontWeight = FontWeight.Normal,
        modifier: Modifier = Modifier

    ) {
        Text(
            title,
            color = color,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = fontWeight,
            modifier = modifier

        )
    }

    //LightSubText
    @Composable
    fun LightSubText(
        title:String,
        color:Color = Color.LightGray,

        ) {
        Text(
            title,
            color = color,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold
        )
    }

    // NormalText Clickable
    @Composable
    fun NormalClickableText(
        title:String,
        color:Color = Color.White,
        modifier: Modifier
    ) {
        Text(
            title,
            color = color,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier
        )
    }

}