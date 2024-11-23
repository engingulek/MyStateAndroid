package com.example.myestate.retrofit
import retrofit2.Call
import com.example.myestate.ui.screens.home.EstateType
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("estateTypes/getAll")
    suspend fun getAllEstateTypes() : Response<List<EstateType>>
}