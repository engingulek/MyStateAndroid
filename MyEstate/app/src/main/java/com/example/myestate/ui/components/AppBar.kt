package com.example.myestate.ui.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.ui.screens.home.HomeScreen

@Composable
fun AppBar(navigateToFav : () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        TextComponents.HeadlineTitle(
            "My Estate",
            Color.Blue,
            modifier = Modifier.weight(1f),
        )
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Icon",
            tint = Color.Blue,
            modifier = Modifier.size(30.dp)
                .clickable {
                    navigateToFav()
                }

        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar({})
}