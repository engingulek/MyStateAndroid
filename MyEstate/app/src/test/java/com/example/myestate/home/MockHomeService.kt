package com.example.myestate.home

import com.example.myestate.ui.screens.home.models.EstateType
import com.example.myestate.ui.screens.home.HomeServiceInterface
import com.example.myestate.ui.screens.home.models.Category

class MockHomeService : HomeServiceInterface {
    var estateTypeError : Boolean = false
    var categoryError : Boolean = false
    private var estateTypeList:Pair<List<EstateType>,Boolean> = Pair(emptyList(),false)
    private var categoryList :  Pair<List<Category>,Boolean> = Pair(emptyList(),false)
    override suspend fun fetchAllEstateType() {
        if (estateTypeError){
            estateTypeList = Pair(emptyList(),true)
        }else{
            val list  = listOf(
                EstateType(1,"All"),
                EstateType(2,"Rent"),
                EstateType(3,"Sale")
            )
            estateTypeList = Pair(list,false)
        }

    }

    override suspend fun getAllEstateType(): Pair<List<EstateType>,Boolean> {
        return  estateTypeList
    }

    override suspend fun fetchAllCategory() {
        if (categoryError){
            categoryList = Pair(emptyList(),true)
        }else{
          val  list =  listOf(
                Category(1,"Test1"),
                Category(2,"Test2"),
                Category(3,"Test3"),
                Category(4,"Test4")
            )
            categoryList = Pair(list,false)

        }

    }

    override suspend fun getAllCategory(): Pair<List<Category>,Boolean> {
        return  categoryList
    }
}