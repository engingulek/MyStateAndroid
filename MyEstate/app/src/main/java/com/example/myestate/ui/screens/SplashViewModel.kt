package com.example.myestate.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.example.myestate.R
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


interface SplashViewModelInterface {

}

class SplashViewModel : ViewModel(),SplashViewModelInterface {
    private val _uiState = mutableStateOf(SplashContract.UiState())
    val state :State<SplashContract.UiState>  = _uiState

    init {
        writeUIState()
    }

    private fun writeUIState(){
        _uiState.value.appTitle = R.string.appName
        _uiState.value.subTitle = R.string.defaultSlogan
        _uiState.value.clickableTextTitle = R.string.clickableTextMember
        _uiState.value.emailButtonType = ButtonType(
            R.string.email,
            0xFF000000,
             0xFFFFFFFF )
        _uiState.value.googleButtonType = ButtonType(
            R.string.google,
            0xFFFF0000,
             0xFFFFFFFF
        )
    }

}