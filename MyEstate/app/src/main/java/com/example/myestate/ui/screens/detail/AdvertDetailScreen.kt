package com.example.myestate.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.detail.views.AdvertDetailBaseInfo
import com.example.myestate.ui.screens.detail.views.AdvertDetailImage
import com.example.myestate.utils.getStringRes
import com.example.myestate.utils.toFormatPrice


@Composable
fun AdvertDetailScreen(
    advertId:Int?,
    viewModel: AdvertDetailViewModel = hiltViewModel()
) {
    viewModel.getAdvertId(advertId)
    val state = viewModel.state.value
    val advertDetailState by viewModel.advertDetail.collectAsState()
    LazyColumn {
        item {
            AdvertDetailImage(advertDetailState.advertDetail?.images)
            AdvertDetailBaseInfo(advertDetailState)
            Column(
                Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),

            ) {
                TextComponents.SubTitle(
                    getStringRes(state.advertInfoTitle),
                    color = Color.Black)
                SubBaseInfoText(title = getStringRes( state.price), value = "${advertDetailState.advertDetail?.price}Tl", type = "price")
                SubBaseInfoText(title = getStringRes(state.advertId), value = "#${advertDetailState.advertDetail?.id}")
                SubBaseInfoText(title = getStringRes(state.estateType), value = "${advertDetailState.advertDetail?.estateType}")
                SubBaseInfoText(title = getStringRes(state.advertDate), value = "${advertDetailState.advertDetail?.advertDate}")
                SubBaseInfoText(title = getStringRes(state.age), value = "${advertDetailState.advertDetail?.age}")
                SubBaseInfoText(title = getStringRes(state.floors), value = "${advertDetailState.advertDetail?.floors}")
                TextComponents.SubTitle(getStringRes(viewModel.state.value.descriptionTitle), Color.Black)
                TextComponents.NormalText("${advertDetailState.advertDetail?.description}",Color.Black)
            }
        }
    }
}

@Composable
private fun SubBaseInfoText(
    title:String,
    value:String,
    type:String = "normal"){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(title,style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal)
        if (type=="price"){
            Text(value,style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)
        }else{
            Text(value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal)
        }

    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AdvertDetailScreenPreview() {
    AdvertDetailScreen(-1)
}