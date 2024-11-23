package com.example.myestate.ui.screens.detail

import com.example.myestate.R

object AdvertDetailContract {
    data class UiState(
        var advertInfoTitle:Int = R.string.empty,
        var descriptionTitle:Int = R.string.empty
    )
}