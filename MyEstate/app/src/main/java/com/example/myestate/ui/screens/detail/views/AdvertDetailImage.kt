package com.example.myestate.ui.screens.detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.R
import com.example.myestate.ui.screens.detail.AdvertDetailContract
import com.example.myestate.ui.screens.detail.AdvertDetailViewModel
import com.example.myestate.ui.screens.home.HomeViewModel
import com.example.myestate.utils.CoilImage

@Composable
fun AdvertDetailImage(
    advertDetailState: AdvertDetailContract.AdvertDetailState?,
    viewModel: AdvertDetailViewModel
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.fillMaxWidth()
            .height(250.dp)
    ) {

        Image(
            painter = CoilImage.loadImageCoil(advertDetailState!!.selectedImageUrl ),
            contentDescription = "base image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
                .height(250.dp))
        LazyRow {
            items(advertDetailState.advertDetail?.images ?: emptyList()){ image ->
                Image(
                    painter = CoilImage.loadImageCoil(image),
                    contentDescription = "advert image",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(50.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .border(color = if (advertDetailState.selectedImageUrl == image) Color.Blue else Color.White,
                            width = 1.dp)
                        .clickable { 
                            viewModel.onAction(AdvertDetailContract.UIAction.clickedImage(image))
                        }
                    ,
                    contentScale = ContentScale.FillBounds,
                )

            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun AdvertDetailImagePreview(){
    AdvertDetailImage(emptyList())
}*/