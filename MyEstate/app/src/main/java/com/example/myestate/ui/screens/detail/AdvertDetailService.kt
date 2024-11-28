package com.example.myestate.ui.screens.detail

import android.util.Log
import com.example.myestate.retrofit.ApiService
import javax.inject.Inject

interface AdvertDetailServiceInterface {
    suspend fun fetchAdvertDetail(id:Int)
    suspend fun getAdvertDetail() : Pair<AdvertDetail?,Boolean>
}


class AdvertDetailService @Inject constructor(private val apiService: ApiService) : AdvertDetailServiceInterface {
    private var advertDetail : Pair<AdvertDetail?,Boolean> = Pair(null,true)
    override suspend fun fetchAdvertDetail(id: Int) {
        try {
            val response = apiService.getAdvertDetail(id)
            if (response.isSuccessful) {
                val detail =   response.body()
                advertDetail = Pair(detail,false)
            } else {
                advertDetail = Pair(null,true)
            }
        } catch (t: Throwable) {
            advertDetail = Pair(null,true)
        }
    }

    override suspend fun getAdvertDetail(): Pair<AdvertDetail?, Boolean> {
        return  advertDetail
    }
}