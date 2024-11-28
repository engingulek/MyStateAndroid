package com.example.myestate.ui.screens.favorite

import com.example.myestate.R
import com.example.myestate.room.Favorite

object FavoriteContract {

    data class FavoriteUiState(
        var title:Int = R.string.empty,
        val list : List<Favorite> = emptyList(),
        var message:Pair<Int,Boolean> = Pair(R.string.empty,true),
    )


    sealed interface UiAction {
        data class clickedFavorite(val id:Int):UiAction

    }
}