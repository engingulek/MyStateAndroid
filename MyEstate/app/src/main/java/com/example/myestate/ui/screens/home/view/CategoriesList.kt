package com.example.myestate.ui.screens.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.HomeContract
import com.example.myestate.ui.screens.home.HomeViewModel
import com.example.myestate.utils.getStringRes

@Composable
fun CategoriesList(viewModel: HomeViewModel){
    val categoryUiState by viewModel.categoryUi.collectAsState()
    Column(verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextComponents.SubTitle(
            getStringRes(categoryUiState.title),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 10.dp))
        LazyRow   {
            items(categoryUiState.list){ category ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .background(
                            color = Color(category.backColor),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .border(width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(12.dp)
                        ).clickable {
                            viewModel.onAction(HomeContract.UiAction.clickedCategory(category.id))
                        }
                ) {

                    TextComponents.NormalText(
                        category.name,
                        color = Color(category.textColor),
                        modifier = Modifier.padding(10.dp)

                    )
                }

            }
        }
    }

}



/*@Preview(showBackground = true)
@Composable
fun CategoriesPreview() {
    CategoriesList(state = HomeContract.UiState())
}*/