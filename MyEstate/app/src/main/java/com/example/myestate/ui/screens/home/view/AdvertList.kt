package com.example.myestate.ui.screens.home.view

import android.graphics.ImageDecoder.ImageInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.R
import com.example.myestate.ui.components.BoxClickable
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeContract
import com.example.myestate.utils.getStringRes

@Composable
fun AdvertList(
    navigateToDetail: () -> Unit,
    state: HomeContract.UiState) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 10.dp)) {
        //Categories
        TextComponents.SubTitle(
            getStringRes(state.advertTitle),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 10.dp))
        LazyColumn   {
            items(20){ index ->
               Column (modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp)
                   .clip(RoundedCornerShape(10.dp))
                   .background(Color.White)
                   .padding(5.dp)
                   .clickable {
                       navigateToDetail()
                   }

               ){
                   ImageInfo()
                   AdvertInfo()
               }
            }
        }
    }
}

@Composable
private fun ImageInfo(){
    Box( modifier = Modifier
        .height(180.dp)
        .clip(RoundedCornerShape(20.dp)),

        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painterResource(R.drawable.testadvertimage),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Image(painterResource(
            R.drawable.no_fav_icon),
            contentDescription = "fav icon",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.padding(10.dp)
                .size(30.dp)
        )
    }
}
@Composable
private fun AdvertInfo() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            TextComponents.LightSubText("#132321312")

            TextComponents.NormalText(
                "Title",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            TextComponents.NormalText(
                "m2",
                color = Color.Black
            )
            TextComponents.NormalText(
                "City/District",
                color = Color.Black
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text("Advert Date")
            TextComponents.NormalText(
                "Price",
                color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdvertListPreview() {
    AdvertList({},
        HomeContract.UiState())
}