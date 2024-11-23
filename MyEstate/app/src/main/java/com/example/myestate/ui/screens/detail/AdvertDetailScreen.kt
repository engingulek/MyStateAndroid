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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.detail.views.AdvertDetailBaseInfo
import com.example.myestate.ui.screens.detail.views.AdvertDetailImage
import com.example.myestate.utils.getStringRes


@Composable
fun AdvertDetailScreen() {
    val viewModel : AdvertDetailViewModelInterface = AdvertDetailViewModel()
    val state = viewModel.state.value
    LazyColumn {
        item {
            AdvertDetailImage()
            AdvertDetailBaseInfo()
            Column(
                Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),

            ) {
                TextComponents.SubTitle(
                    getStringRes(state.advertInfoTitle),
                    color = Color.Black)
                SubBaseInfoText(title = getStringRes( state.price), value = "20.000Tl", type = "price")
                SubBaseInfoText(title = getStringRes(state.advertId), value = "#13231321")
                SubBaseInfoText(title = getStringRes(state.estateType), value = "Rent")
                SubBaseInfoText(title = getStringRes(state.advertDate), value = "23.11.2024")
                SubBaseInfoText(title = getStringRes(state.age), value = "10")
                SubBaseInfoText(title = getStringRes(state.floors), value = "3")
                TextComponents.SubTitle(getStringRes(viewModel.state.value.descriptionTitle), Color.Black)
                TextComponents.NormalText("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",Color.Black)
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
    AdvertDetailScreen()
}