package com.example.myestate.ui.screens.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myestate.R
import com.example.myestate.retrofit.ApiService
import com.example.myestate.ui.components.BoxClickable
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeContract
import com.example.myestate.ui.screens.home.HomeScreen
import com.example.myestate.ui.screens.home.HomeService
import com.example.myestate.ui.screens.home.HomeViewModel
import com.example.myestate.ui.screens.home.models.EstateType
import com.example.myestate.utils.getStringRes
import okhttp3.internal.wait

@Composable
fun EstateTypeList(
    viewModel: HomeViewModel
) {
    val estateTypeUiState by viewModel.estateTypeUi.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextComponents.SubTitle(
            getStringRes(estateTypeUiState.title),
            color = Color.Black)

        if(estateTypeUiState.error.second){
            Column {
                TextComponents.NormalText(getStringRes(estateTypeUiState.error.first), Color.Red)
            }
        }else{
            LazyRow {
                items(estateTypeUiState.list){ estateType ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .background(
                                color = Color(estateType.backColor),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .border(width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(12.dp)
                            ).clickable {
                                viewModel.onAction(HomeContract.UiAction.clickedEstateType(estateType.id))
                            }
                    ) {

                        TextComponents.NormalText(
                            estateType.type,
                            color = Color(estateType.textColor),
                            modifier = Modifier.padding(10.dp)

                        )
                    }

                }
            }
        }

    }
}



/*@Preview(showBackground = true)
@Composable
fun EstateTypeListPreview() {
    EstateTypeList(HomeContract.UiState(), viewModel = HomeViewModel())
}*/