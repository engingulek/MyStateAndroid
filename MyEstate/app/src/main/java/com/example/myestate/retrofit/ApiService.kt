package com.example.myestate.retrofit
import com.example.myestate.ui.screens.home.models.Category
import com.example.myestate.ui.screens.home.models.EstateType
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("estateTypes/getAll")
    suspend fun getAllEstateTypes() : Response<List<EstateType>>

    @GET("categories/getAll")
    suspend fun getAllCategories() : Response<List<Category>>
}