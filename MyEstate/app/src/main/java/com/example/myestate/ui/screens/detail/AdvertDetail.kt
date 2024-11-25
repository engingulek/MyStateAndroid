package com.example.myestate.ui.screens.detail

import com.google.gson.annotations.SerializedName

data class AdvertDetail(
    @SerializedName("id") val id: Int,
    @SerializedName("images") val images: List<String>,
    @SerializedName("title") val title: String,
    @SerializedName("squareMeter") val squareMeter: Int,
    @SerializedName("city") val city: String,
    @SerializedName("district") val district: String,
    @SerializedName("advertDate") val advertDate: String,
    @SerializedName("estateType") val estateType: String,
    @SerializedName("price") val price: Int,
    @SerializedName("age") val age: Int,
    @SerializedName("floors") val floors: Int,
    @SerializedName("room") val room: Int,
    @SerializedName("bathroom") val bathroom: Int,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String
)