package com.example.myestate.ui.screens.home

import android.util.Log
import com.example.myestate.retrofit.ApiService
import com.example.myestate.ui.screens.home.models.Category
import com.example.myestate.ui.screens.home.models.EstateType
import javax.inject.Inject

interface HomeServiceInterface {
  suspend  fun fetchAllEstateType()
  suspend   fun getAllEstateType() : List<EstateType>

  suspend fun fetchAllCategory()
  suspend fun getAllCategory() : List<Category>
}


class HomeService @Inject constructor(private val apiService: ApiService) : HomeServiceInterface {
    private var estateTypeList : List<EstateType> = emptyList()
    private var categoryList : List<Category> = emptyList()

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

    override suspend fun fetchAllCategory() {
        try {
            val response = apiService.getAllCategories()
            if (response.isSuccessful) {
                categoryList = response.body() ?: emptyList()
            } else {
                Log.e("Service Error", "Error fetching data: ${response.code()}")
            }
        } catch (t: Throwable) {
            categoryList = emptyList()
            Log.e("Service Error", "Error: ${t.message}")
        }
    }

    override suspend fun getAllCategory(): List<Category> {
        return  categoryList
    }
}