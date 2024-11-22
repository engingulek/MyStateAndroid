package com.example.myestate.ui.screens.home
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.example.myestate.ui.screens.home.view.Categories

@Composable
fun HomeScreen() {
    val viewModel:HomeViewModelInterface = HomeViewModel()
    Column {
        Categories(state = viewModel.state.value)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}