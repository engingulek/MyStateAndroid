package com.example.myestate.ui.screens.home.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    val textColor: Long = 0xFF52607D,
    val backColor : Long = 0xFFFFFFFF
) {
}