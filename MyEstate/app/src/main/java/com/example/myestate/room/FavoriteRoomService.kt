package com.example.myestate.room

import javax.inject.Inject
import javax.inject.Singleton




@Singleton
class FavoriteRoomService @Inject constructor(private val favoriteDao: FavoriteDao) {

    suspend fun getAllFav(): List<Favorite> {
        return favoriteDao.allFavorite()
    }

    suspend fun addFav(fav:Favorite){
         favoriteDao.addAdvertToFav(fav)
    }

    suspend fun favControl(id:Int) : Int {
       return favoriteDao.favControl(id)
    }

    suspend fun deleteFav(id:Int){
        favoriteDao.deleteFav(id)
    }
}