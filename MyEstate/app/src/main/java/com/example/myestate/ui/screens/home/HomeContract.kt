package com.example.myestate.ui.screens.home

import com.example.myestate.R

object HomeContract {

    data class UiState(
        var categoryTitle:Int = R.string.empty,
        var estateType:Int = R.string.empty
    )
}