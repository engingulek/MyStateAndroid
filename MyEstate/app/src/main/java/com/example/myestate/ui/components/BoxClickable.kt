package com.example.myestate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxClickable(
    title:String,
    textColor: Color,
    backColor: Color,

                 ) {

    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .background(
                color = backColor,
                shape = RoundedCornerShape(12.dp)
            )
            .border(width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            ).clickable {

            }
    ) {

        TextComponents.NormalText(
            title,
            color = textColor,
            modifier = Modifier.padding(10.dp)

        )
    }
}