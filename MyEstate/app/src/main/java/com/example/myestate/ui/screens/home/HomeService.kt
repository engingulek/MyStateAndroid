package com.example.myestate.ui.screens.home

import android.util.Log
import com.example.myestate.retrofit.ApiService
import com.example.myestate.ui.screens.home.models.AdvertOnHome
import com.example.myestate.ui.screens.home.models.Category
import com.example.myestate.ui.screens.home.models.EstateType
import javax.inject.Inject

interface HomeServiceInterface {
  suspend  fun fetchAllEstateType()
  suspend   fun getAllEstateType() : Pair<List<EstateType>,Boolean>

  suspend fun fetchAllCategory()
  suspend fun getAllCategory() : Pair<List<Category>,Boolean>

  suspend fun fetchAllAdvertsOnHome()
  suspend fun getAllAdvertsOnHome() : Pair<List<AdvertOnHome>,Boolean>
}


class HomeService @Inject constructor(private val apiService: ApiService) : HomeServiceInterface {
    private var estateTypeList : Pair<List<EstateType>,Boolean> = Pair(emptyList(),false)
    private var categoryList :  Pair<List<Category>,Boolean> = Pair(emptyList(),false)
    private var advertOnHomeList : Pair<List<AdvertOnHome>,Boolean> = Pair(emptyList(),false)

    override suspend fun fetchAllEstateType() {
        try {
            val response = apiService.getAllEstateTypes()
            if (response.isSuccessful) {
                val list =   response.body() ?: emptyList()
                estateTypeList = Pair(list,false)
            } else {
                estateTypeList = Pair(emptyList(),true)
            }
        } catch (t: Throwable) {
            estateTypeList = Pair(emptyList(),true)
        }
    }

    override suspend  fun getAllEstateType() :Pair<List<EstateType>,Boolean>  {
        return estateTypeList
    }

    override suspend fun fetchAllCategory() {
        try {
            val response = apiService.getAllCategories()
            if (response.isSuccessful) {
                val list =   response.body() ?: emptyList()
                categoryList = Pair(list,false)
            } else {
                categoryList = Pair(emptyList(),true)
            }
        } catch (t: Throwable) {
            categoryList = Pair(emptyList(),true)
        }
    }

    override suspend fun getAllCategory(): Pair<List<Category>,Boolean> {
        return  categoryList
    }

    override suspend fun fetchAllAdvertsOnHome() {
        try {
            val response = apiService.getAllAdvertsOnHome()
            if (response.isSuccessful) {
                val list =   response.body() ?: emptyList()
                advertOnHomeList = Pair(list,false)
            } else {
                advertOnHomeList = Pair(emptyList(),true)
            }
        } catch (t: Throwable) {
            advertOnHomeList = Pair(emptyList(),true)
        }
    }

    override suspend fun getAllAdvertsOnHome(): Pair<List<AdvertOnHome>, Boolean> {
        return advertOnHomeList
    }
}