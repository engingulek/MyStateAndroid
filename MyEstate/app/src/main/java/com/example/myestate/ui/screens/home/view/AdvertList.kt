package com.example.myestate.ui.screens.home.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myestate.R
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeViewModel
import com.example.myestate.ui.screens.home.models.AdvertOnHome
import com.example.myestate.utils.CoilImage
import com.example.myestate.utils.getStringRes
import com.example.myestate.utils.toFormatPrice

@Composable
fun AdvertList(
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel) {
    val advertOnHomeUiState by viewModel.advertOnHomeUi.collectAsState()
    Column(verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 10.dp)) {

        TextComponents.SubTitle(
            getStringRes(advertOnHomeUiState.title),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 10.dp))
        if (advertOnHomeUiState.message.second){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()

            ){
                TextComponents.HeadlineTitle(
                    getStringRes(advertOnHomeUiState.message.first),
                    Color.Red)
            }
        }else{
            LazyColumn   {
                items(advertOnHomeUiState.list){ advert ->
                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(5.dp)
                        .clickable {
                            navigateToDetail(advert.id)
                        }

                    ){
                        ImageInfo(advert.images[0])
                        AdvertInfo(advert)
                    }
                }
            }
        }

    }
}

@Composable
private fun ImageInfo(url:String){
    Box( modifier = Modifier
        .fillMaxWidth()
        .height(180.dp)
        .clip(RoundedCornerShape(20.dp)),

        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = CoilImage.loadImageCoil(url),
            contentDescription = "advert base image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()

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
private fun AdvertInfo(advertOnHome: AdvertOnHome) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {

        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            TextComponents.LightSubText("#${advertOnHome.id}")

            TextComponents.NormalText(
                advertOnHome.title,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            TextComponents.NormalText(
                "${advertOnHome.squareMeter} m2",
                color = Color.Black
            )
            TextComponents.NormalText(
                "${advertOnHome.city},${advertOnHome.district}",
                color = Color.Black
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(advertOnHome.advertDate)
            TextComponents.NormalText(
                "${advertOnHome.price.toFormatPrice()}Tl/${advertOnHome.estateType}",
                color = Color.Black)
            Text(advertOnHome.category)
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun AdvertListPreview() {
    AdvertList({},
        HomeContract.UiState())
}*/