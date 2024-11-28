package com.example.myestate.ui.screens.home.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EstateType (
   @SerializedName("id") val id: Int,
   @SerializedName("type") val type: String,
   val textColor: Long = 0xFF52607D,
   val backColor : Long = 0xFFFFFFFF
) : Serializable