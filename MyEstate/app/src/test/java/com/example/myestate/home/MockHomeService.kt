package com.example.myestate.home

import com.example.myestate.ui.screens.home.models.EstateType
import com.example.myestate.ui.screens.home.HomeServiceInterface

class MockHomeService : HomeServiceInterface {
    private var estateTypeList:List<EstateType> = emptyList()
    override suspend fun fetchAllEstateType() {
        estateTypeList  = listOf(
            EstateType(1,"All"),
            EstateType(2,"Rent"),
            EstateType(3,"Sale")
        )
    }

    override suspend fun getAllEstateType(): List<EstateType> {
        return  estateTypeList
    }
}