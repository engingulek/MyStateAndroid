package com.example.myestate.ui.screens.home
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myestate.retrofit.ApiService
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.view.AdvertList
import com.example.myestate.ui.screens.home.view.CategoriesList
import com.example.myestate.ui.screens.home.view.EstateTypeList
import com.example.myestate.utils.getStringRes
import dagger.hilt.android.lifecycle.HiltViewModel



@Composable
fun HomeScreen(
    navigateToDetail: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()

   Column {
       EstateTypeList(state = uiState)
       CategoriesList(state = uiState)
       AdvertList(
           navigateToDetail,
           state = uiState)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen({})
}