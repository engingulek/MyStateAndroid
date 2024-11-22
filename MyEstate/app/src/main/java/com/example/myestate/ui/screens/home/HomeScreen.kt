package com.example.myestate.ui.screens.home
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myestate.ui.screens.home.view.CategoriesList
import com.example.myestate.ui.screens.home.view.EstateTypeList


@Composable
fun HomeScreen() {
    val viewModel:HomeViewModelInterface = HomeViewModel()
    Column {
        EstateTypeList(state = viewModel.state.value)
        CategoriesList(state = viewModel.state.value)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}