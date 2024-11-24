package com.example.myestate.ui.screens.home

import com.example.myestate.R


object HomeContract {

    data class UiState(
        var categoryTitle: Int = R.string.empty,
        var advertTitle: Int = R.string.empty,
    )

    data class  EstateTypeUiState(
        var title:Int = R.string.empty,
        var list: List<EstateType> = emptyList(),
    )





    sealed interface UiAction {
        data class clickedEstateType(val id:Int):UiAction
    }


}
