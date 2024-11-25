package com.example.myestate.di

import com.example.myestate.retrofit.ApiService
import com.example.myestate.ui.screens.detail.AdvertDetailService
import com.example.myestate.ui.screens.detail.AdvertDetailServiceInterface
import com.example.myestate.ui.screens.home.HomeService
import com.example.myestate.ui.screens.home.HomeServiceInterface
import com.example.myestate.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApiService() : ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeService(apiService: ApiService) : HomeServiceInterface{
        return   HomeService(apiService)
    }

    @Provides
    @Singleton
    fun provideAdvertDetail(apiService: ApiService) : AdvertDetailServiceInterface {
        return  AdvertDetailService(apiService)
    }
}