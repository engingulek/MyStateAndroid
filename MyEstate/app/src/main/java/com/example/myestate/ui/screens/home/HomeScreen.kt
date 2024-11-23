package com.example.myestate.ui.screens.home
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.view.AdvertList
import com.example.myestate.ui.screens.home.view.CategoriesList
import com.example.myestate.ui.screens.home.view.EstateTypeList
import com.example.myestate.utils.getStringRes


@Composable
fun HomeScreen(navigateToDetail: () -> Unit) {
    val viewModel:HomeViewModelInterface = HomeViewModel()
    val viewList =
   Column {
       EstateTypeList(state = viewModel.state.value)
       CategoriesList(state = viewModel.state.value)
       AdvertList(
           navigateToDetail,
           state = viewModel.state.value)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen({})
}