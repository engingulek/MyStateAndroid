package com.example.myestate.ui.screens.favorite

import com.example.myestate.room.Favorite
import com.example.myestate.room.FavoriteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRoomService @Inject constructor(private val favoriteDao: FavoriteDao) {

    suspend fun getAllFav(): List<Favorite> {
        return favoriteDao.allFavorite()
    }
}