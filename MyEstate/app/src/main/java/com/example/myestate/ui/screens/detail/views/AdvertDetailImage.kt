package com.example.myestate.ui.screens.detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.myestate.utils.CoilImage

@Composable
fun AdvertDetailImage(images:List<String>?) {
    Box(
        contentAlignment = Alignment.BottomEnd) {
        Image(
            painterResource(R.drawable.testadvertimage),
            contentDescription = "base image")
        LazyRow {
            items(images ?: emptyList()){ image ->
                Image(
                    painter = CoilImage.loadImageCoil(image),
                    contentDescription = "advert image",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(50.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .border(color = if (0 == 0) Color.Blue else Color.White,
                            width = 1.dp)
                    ,
                    contentScale = ContentScale.FillBounds,
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdvertDetailImagePreview(){
    AdvertDetailImage(emptyList())
}