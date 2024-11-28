package com.example.myestate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.ui.screens.home.HomeScreen

@Composable
fun AppBar(
    title:String,
    navigateLeftIconAction : () -> Unit? = {},
           leftIcon : Int? = null,
           rightIcon : Int? = null,
           navigateRightIconAction : () -> Unit? = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (leftIcon != null){
            Image(painterResource(leftIcon),
                contentDescription = "left icon",
                modifier = Modifier.size(30.dp)
                    .clickable {
                        navigateLeftIconAction()
                    }

            )
        }
        TextComponents.HeadlineTitle(
            title,
            Color.Blue,
            modifier = Modifier.weight(1f),
        )
        if (rightIcon != null){
            Image(painterResource(rightIcon),
                contentDescription = "left icon",
                modifier = Modifier.size(30.dp)
                    .clickable {
                        navigateRightIconAction()
                    }

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar("Title")
}