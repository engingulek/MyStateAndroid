package com.example.myestate.ui.screens.home.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AdvertOnHome (
   @SerializedName("id") val id: Int,
   @SerializedName("images") val images: List<String>,
   @SerializedName("title") val title: String,
   @SerializedName("squareMeter") val squareMeter: Long,
   @SerializedName("city") val city: String,
   @SerializedName("district") val district: String,
   @SerializedName("advertDate") val advertDate: String,
   @SerializedName("estateType") val estateType: String,
   @SerializedName("price") val price: Long,
   @SerializedName("category") val category: String
) : Serializable
