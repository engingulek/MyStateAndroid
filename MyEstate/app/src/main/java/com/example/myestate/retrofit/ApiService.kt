package com.example.myestate.retrofit
import com.example.myestate.ui.screens.detail.AdvertDetail
import com.example.myestate.ui.screens.home.models.AdvertOnHome
import com.example.myestate.ui.screens.home.models.Category
import com.example.myestate.ui.screens.home.models.EstateType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("estateTypes/getAll")
    suspend fun getAllEstateTypes() : Response<List<EstateType>>

    @GET("categories/getAll")
    suspend fun getAllCategories() : Response<List<Category>>

    @GET("adverts/getAll")
    suspend fun getAllAdvertsOnHome() : Response<List<AdvertOnHome>>

    @GET("adverts/advertDetail")
    suspend fun getAdvertDetail(@Query("id") id:Int) : Response<AdvertDetail>
}