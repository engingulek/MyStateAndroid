package com.example.myestate.ui.screens.detail

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

@Composable
fun AdvertDetailBaseInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp))
    {
        TextComponents.SubTitle("Luxury villa in the garden", color = Color.Black)
        TextComponents.NormalText("Star Estate", Color.Black)
        ImageDrawableText(R.drawable.location_pin,"Bahcelievler/Istanbul")
        LazyRow(modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)

        )
        {
            items(3){
                Row(
                    modifier = Modifier

                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 5.dp)

                ) {
                    TextComponents.NormalText("3", Color.Black)
                    Image(
                        painterResource(R.drawable.bedroom),
                        contentDescription = "location_pin")
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdvertDetailBaseInfoPreview(){
    AdvertDetailBaseInfo()
}