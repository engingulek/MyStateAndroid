package com.example.myestate.ui.screens.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeContract
import com.example.myestate.utils.getStringRes

@Composable
fun Categories(state:HomeContract.UiState){
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        //Categories
        TextComponents.SubTitle(
            getStringRes(state.categoryTitle),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 10.dp))
        LazyRow   {
            items(20){ index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .background(color = if(index == 0) Color.Blue else
                            Color.White,shape = RoundedCornerShape(12.dp)
                        )
                        .border(width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {

                    TextComponents.NormalClickableText(
                        "Category",
                        color =  if(index == 0) Color.White else
                            Color.Blue,
                        modifier = Modifier.padding(10.dp)
                        )
                }
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun CategoriesPreview() {
    Categories(state = HomeContract.UiState())
}