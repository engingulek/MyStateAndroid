package com.example.myestate.ui.screens.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myestate.ui.components.BoxClickable
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeContract
import com.example.myestate.ui.screens.home.HomeScreen
import com.example.myestate.utils.getStringRes

@Composable
fun EstateTypeList(state: HomeContract.UiState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextComponents.SubTitle(
            getStringRes(state.estateType.title),
            color = Color.Black)
        LazyRow {
            items(state.estateType.list){ estateType ->

                BoxClickable(
                    estateType.type,
                    if(estateType.id == 1) Color.White else
                        Color.Blue,
                    if(estateType.id == 1) Color.Blue else
                        Color.White,
                    Modifier.padding(10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EstateTypeListPreview() {
    EstateTypeList(HomeContract.UiState())
}