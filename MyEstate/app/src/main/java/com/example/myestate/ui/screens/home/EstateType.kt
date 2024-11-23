package com.example.myestate.ui.screens.home

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EstateType (
   @SerializedName("id") val id: Int,
   @SerializedName("type") val type: String
) : Serializable