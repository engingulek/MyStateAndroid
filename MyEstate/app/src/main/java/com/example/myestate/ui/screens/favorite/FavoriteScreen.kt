package com.example.myestate.ui.screens.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.R
import com.example.myestate.ui.components.AppBar
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeScreen

@Composable
fun FavoriteScreen(popNavigation:() -> Unit) {
    Column {
        AppBar(
            "Favorites",
            leftIcon = R.drawable.left_arrow,
            navigateLeftIconAction = popNavigation
        )
        LazyColumn {
            items(10){
                FavAdvertItem()
            }
        }
    }



}


@Composable
fun FavAdvertItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.testadvertimage),
            contentDescription = "Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(80.dp)
        )


        Column(
            verticalArrangement = Arrangement.spacedBy(35.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Title",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Image(painterResource(R.drawable.fav_icon), contentDescription = "fav icon")
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "City,District",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                TextComponents.NormalText(
                    "Price",
                    color = Color.Blue
                )
            }

        }
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoriteScreenPreview() {
    FavoriteScreen({})
}