package com.example.myestate.ui.screens.home
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import com.example.myestate.ui.components.TextComponents
import com.example.myestate.ui.screens.home.view.AdvertList
import com.example.myestate.ui.screens.home.view.CategoriesList
import com.example.myestate.ui.screens.home.view.EstateTypeList
import com.example.myestate.utils.getStringRes
import org.w3c.dom.Text



@Composable
fun HomeScreen(
    navigateToDetail: (Int) -> Unit,
    navigateTofFavorite:() -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsState()
    if (uiState.error.second){
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextComponents.HeadlineTitle(getStringRes(uiState.error.first), Color.Red)
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(16.dp),
                onClick = navigateTofFavorite) {
                Text("Favorites")
            }
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
    HomeScreen({},{})
}