package com.example.myestate.ui.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myestate.R

import com.example.myestate.room.FavoriteRoomService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRoomService: FavoriteRoomService) : ViewModel() {
    private val _favUiState = MutableStateFlow(FavoriteContract.FavoriteUiState())
    val favUiState: StateFlow<FavoriteContract.FavoriteUiState> = _favUiState

    init {
        fetchFavList()
    }


    private fun fetchFavList(){
        viewModelScope.launch {
            val list = favoriteRoomService.getAllFav()
            Log.e("Fav List","${list.isEmpty()}")
           if (list.isEmpty()){
                _favUiState.value = _favUiState.value.copy(
                    title = R.string.favorites,
                    list = emptyList(),
                    message = Pair(R.string.noData, true)

                )
            }else{
                _favUiState.value = _favUiState.value.copy(
                    title = R.string.favorites,
                    list = list,
                    message = Pair(R.string.empty, false)

                )
            }

        }
    }
}