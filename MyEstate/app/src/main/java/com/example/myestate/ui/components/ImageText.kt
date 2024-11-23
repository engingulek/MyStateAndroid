package com.example.myestate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myestate.R

@Composable
fun ImageDrawableText(image:Int,title:String,type:String="left") {
    if(type == "left"){
        Row {

            Image(painterResource(image),
                contentDescription = "location_pin")
            TextComponents.NormalText(title, Color.Gray)

        }
    }else{
        Row {
            TextComponents.NormalText(title, Color.Gray)
            Image(painterResource(image),
                contentDescription = "location_pin")


        }
    }

}


@Preview(showBackground = true)
@Composable
fun ImageTextPreview(){
    ImageDrawableText(R.drawable.location_pin,"Bahcelievler/Istanbul")
}