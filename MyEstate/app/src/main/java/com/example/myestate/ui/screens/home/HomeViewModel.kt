package com.example.myestate.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.myestate.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface HomeViewModelInterface {
    var state : StateFlow<HomeContract.UiState>
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val service: HomeServiceInterface) : ViewModel(),HomeViewModelInterface {
    private val _uiState = MutableStateFlow(HomeContract.UiState())
    override var state : StateFlow<HomeContract.UiState> = _uiState.asStateFlow()

    init {
        writeUiState()
        fetchData()
    }

    private fun writeUiState(){
        _uiState.value.categoryTitle = R.string.categories
        _uiState.value.advertTitle = R.string.adverts
        _uiState.value.estateType.title = R.string.estateType
    }

    private fun fetchData(){
        viewModelScope.launch {
            service.fetchAllEstateType()
            val list = service.getAllEstateType()
            _uiState.value.estateType.list = list
        }
    }
}