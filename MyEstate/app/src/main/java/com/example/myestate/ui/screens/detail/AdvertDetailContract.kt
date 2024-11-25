package com.example.myestate.ui.screens.detail

import com.example.myestate.R

object AdvertDetailContract {
    data class UiState(
        var advertInfoTitle:Int = R.string.empty,
        var descriptionTitle:Int = R.string.empty,
        var price:Int = R.string.empty,
        var advertId:Int = R.string.empty,
        var estateType:Int = R.string.empty,
        var advertDate:Int = R.string.empty,
        var age:Int = R.string.empty,
        var floors:Int = R.string.empty
    )

    data class AdvertDetailState(
       var advertDetail:AdvertDetail? = null,
        var error:Pair<Int,Boolean> = Pair(R.string.errorMessage,true)

    )
}