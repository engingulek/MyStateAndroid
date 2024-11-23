package com.example.myestate.ui.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myestate.R


interface AdvertDetailViewModelInterface{
    var state : State<AdvertDetailContract.UiState>
}

class AdvertDetailViewModel() : ViewModel(),AdvertDetailViewModelInterface {
    private val _uiState = mutableStateOf(AdvertDetailContract.UiState())
    override var state : State<AdvertDetailContract.UiState> = _uiState

    init {
        writeUiState()
    }
    private  fun writeUiState(){
        _uiState.value = AdvertDetailContract.UiState(
            R.string.advertInfo,
            R.string.description
        )
    }
}