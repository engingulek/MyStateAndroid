package com.example.myestate.ui.screens.home

import android.util.Log
import com.example.myestate.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

interface HomeServiceInterface {
  suspend  fun fetchAllEstateType()
    suspend   fun getAllEstateType() : List<EstateType>
}


class HomeService @Inject constructor(private val apiService: ApiService) : HomeServiceInterface {
    private var estateTypeList : List<EstateType> = emptyList()

    override suspend fun fetchAllEstateType() {
        try {
            val response = apiService.getAllEstateTypes()
            if (response.isSuccessful) {
                estateTypeList = response.body() ?: emptyList()
            } else {
                Log.e("Service Error", "Error fetching data: ${response.code()}")
            }
        } catch (t: Throwable) {
            estateTypeList = emptyList()
            Log.e("Service Error", "Error: ${t.message}")
        }
    }

    override suspend  fun getAllEstateType() : List<EstateType>  {
        return estateTypeList
    }
}