package com.example.myestate.home

import com.example.myestate.ui.screens.home.models.EstateType
import com.example.myestate.ui.screens.home.HomeServiceInterface
import com.example.myestate.ui.screens.home.models.AdvertOnHome
import com.example.myestate.ui.screens.home.models.Category

class MockHomeService : HomeServiceInterface {
    var estateTypeError : Boolean = false
    var categoryError : Boolean = false
    var advertOnHomeError : Boolean = false
    private var estateTypeList:Pair<List<EstateType>,Boolean> = Pair(emptyList(),false)
    private var categoryList :  Pair<List<Category>,Boolean> = Pair(emptyList(),false)
    private var advertOnHomeList : Pair<List<AdvertOnHome>,Boolean> = Pair(emptyList(),false)
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

    override suspend fun fetchAllAdvertsOnHome() {
        if (advertOnHomeError){
            advertOnHomeList = Pair(emptyList(),true)
        }else{
            val list = listOf(
                AdvertOnHome(1, emptyList(),
                    "testtitlr",123,
                    "testCity","testDistrict","tesst date","testestype",100000, "testcategory"),

                        AdvertOnHome(1, emptyList(),
                "testtitlr",123,
                "testCity","testDistrict","tesst date","Rent",100000, "Flat")
            )
            advertOnHomeList = Pair(list,false)
        }
    }

    override suspend fun getAllAdvertsOnHome(): Pair<List<AdvertOnHome>, Boolean> {
        return advertOnHomeList
    }
}