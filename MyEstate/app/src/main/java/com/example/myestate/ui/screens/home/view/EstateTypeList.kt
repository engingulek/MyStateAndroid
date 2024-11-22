package com.example.myestate.ui.screens.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myestate.ui.components.BoxClickable
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeContract
import com.example.myestate.utils.getStringRes

@Composable
fun EstateTypeList(state: HomeContract.UiState) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextComponents.SubTitle(
            getStringRes(state.estateType),
            color = Color.Black)
        LazyRow {
            items(3) { index ->
                BoxClickable(
                    "Estate Type",
                    if(index == 0) Color.White else
                        Color.Blue,
                    if(index == 0) Color.Blue else
                        Color.White,
                    Modifier.padding(10.dp))

            }
        }
    }
}