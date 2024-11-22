package com.example.myestate.ui.screens.splash

import com.example.myestate.R

object SplashContract {
    //UiState
    data class UiState(
        var appTitle:Int = R.string.empty,
        var subTitle:Int  = R.string.empty,
        var clickableTextTitle:Int  = R.string.empty,
        var emailButtonType: ButtonType = ButtonType(
            R.string.email,
            0xFF000000,
            0xFFFFFFFF ),
        var googleButtonType: ButtonType = ButtonType(
            R.string.email,
            0xFF000000,
            0xFFFFFFFF )
    )


}


data class ButtonType(val text:Int,
                      val backColor:Long,
                      val textColor: Long
    )