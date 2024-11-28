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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myestate.R
import com.example.myestate.room.Favorite
import com.example.myestate.ui.components.AppBar
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeScreen
import com.example.myestate.utils.CoilImage
import com.example.myestate.utils.getStringRes
import com.example.myestate.utils.toFormatPrice

@Composable
fun FavoriteScreen(
    popNavigation:() -> Unit,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val state by viewModel.favUiState.collectAsState()
    Column {
        AppBar(
            getStringRes(state.title),
            leftIcon = R.drawable.left_arrow,
            navigateLeftIconAction = popNavigation
        )
        if (state.message.second){
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()) {
                TextComponents.HeadlineTitle(
                    getStringRes(state.message.first),
                    Color.Red
                )
            }
        }else{
            LazyColumn {
                items(state.list){ fav ->
                    FavAdvertItem(fav)
                }
            }
        }

    }
}


@Composable
fun FavAdvertItem(fav:Favorite) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ) {
        Image(
            painter = CoilImage.loadImageCoil(fav.imageUrl),
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
                    text = fav.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Image(painterResource(R.drawable.fav_icon), contentDescription = "fav icon")
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "${fav.city},${fav.district}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                TextComponents.NormalText(
                    fav.price.toLong().toFormatPrice(),
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