package com.example.myestate.ui.screens.home

import com.example.myestate.R
import com.example.myestate.ui.screens.home.models.Category
import com.example.myestate.ui.screens.home.models.EstateType


object HomeContract {

    data class UiState(
       // var categoryTitle: Int = R.string.empty,
       // var advertTitle: Int = R.string.empty,
        var error:Pair<Int,Boolean> = Pair(R.string.empty, false)
    )

    data class  EstateTypeUiState(
        var title:Int = R.string.empty,
        var list: List<EstateType> = emptyList(),
        var error:Pair<Int,Boolean> = Pair(R.string.empty, false)

    )

    data class CategoryUiState(
        var title:Int = R.string.empty,
        var list : List<Category> = emptyList(),
        var error:Pair<Int,Boolean> = Pair(R.string.empty, false)
    )





    sealed interface UiAction {
        data class clickedEstateType(val id:Int):UiAction
        data class clickedCategory(val id:Int):UiAction
    }


}
