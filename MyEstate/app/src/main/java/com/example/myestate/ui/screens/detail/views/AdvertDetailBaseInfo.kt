package com.example.myestate.ui.screens.detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.R
import com.example.myestate.ui.components.ImageDrawableText
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.detail.AdvertDetailContract

@Composable
fun AdvertDetailBaseInfo(detail: AdvertDetailContract.AdvertDetailState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp))
    {
        TextComponents.SubTitle("${detail.advertDetail?.title}", color = Color.Black)
        ImageDrawableText(R.drawable.location_pin,"${detail.advertDetail?.district}/${detail.advertDetail?.city}")
        LazyRow(modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)

        )
        {
            item{
                RoomInfo(detail.advertDetail?.room,R.drawable.bedroom)
                RoomInfo(detail.advertDetail?.bathroom,R.drawable.bathroom)
                RoomInfo(detail.advertDetail?.squareMeter,R.drawable.square_area
                )

            }

        }
    }
}


@Composable
private fun RoomInfo(size:Int?,image:Int){
    Row(
        modifier = Modifier

            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            )

            .padding(horizontal = 20.dp, vertical = 5.dp)

    ) {
        TextComponents.NormalText("${size}", Color.Black)
        Image(
            painterResource(image),
            contentDescription = "icon")
    }
}

/*@Preview(showBackground = true)
@Composable
fun AdvertDetailBaseInfoPreview(){
    AdvertDetailBaseInfo()
}*/