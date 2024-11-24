package com.example.myestate.home

import com.example.myestate.ui.screens.home.models.EstateType
import com.example.myestate.ui.screens.home.HomeServiceInterface
import com.example.myestate.ui.screens.home.models.Category

class MockHomeService : HomeServiceInterface {
    private var estateTypeList:List<EstateType> = emptyList()
    private var categoryList : List<Category> = emptyList()
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

    override suspend fun fetchAllCategory() {
        categoryList =  listOf(
            Category(1,"Test1"),
                    Category(2,"Test2"),
        Category(3,"Test3"),
        Category(4,"Test4")
        )
    }

    override suspend fun getAllCategory(): List<Category> {
        return  categoryList
    }
}