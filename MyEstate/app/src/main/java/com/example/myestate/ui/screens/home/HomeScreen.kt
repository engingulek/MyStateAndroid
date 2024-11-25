package com.example.myestate.ui.screens.home
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.view.AdvertList
import com.example.myestate.ui.screens.home.view.CategoriesList
import com.example.myestate.ui.screens.home.view.EstateTypeList
import com.example.myestate.utils.getStringRes
import org.w3c.dom.Text


@Composable
fun HomeScreen(
    navigateToDetail: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    if (uiState.error.second){
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextComponents.HeadlineTitle(getStringRes(uiState.error.first), Color.Red)
        }

    }else{
        Column {

            EstateTypeList(
                viewModel = viewModel
            )
            CategoriesList(viewModel=viewModel)
            AdvertList(
                navigateToDetail,
                viewModel)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen({})
}