package com.example.myestate.ui.screens.home

import com.example.myestate.R

object HomeContract {

    data class UiState(
        var categoryTitle: Int = R.string.empty,
        var estateType: EstateTypeUiState = EstateTypeUiState(R.string.empty, emptyList()),
        var advertTitle: Int = R.string.empty,
    )

    data class  EstateTypeUiState(var title:Int,var list: List<EstateType>){}

}
