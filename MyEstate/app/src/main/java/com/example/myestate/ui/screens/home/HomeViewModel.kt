package com.example.myestate.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.myestate.R

interface HomeViewModelInterface {
    var state : State<HomeContract.UiState>
}

class HomeViewModel : ViewModel(),HomeViewModelInterface {
    private val _uiState = mutableStateOf(HomeContract.UiState())
    override var state : State<HomeContract.UiState> = _uiState

    init {
        writeUiState()
    }

    private fun writeUiState(){
        _uiState.value.categoryTitle = R.string.categories
    }
}