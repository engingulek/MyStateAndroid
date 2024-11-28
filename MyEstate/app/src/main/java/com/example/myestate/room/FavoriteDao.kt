package com.example.myestate.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    suspend fun allFavorite() : List<Favorite>

   @Insert
    suspend fun addAdvertToFav(fav:Favorite)

    @Query("SELECT count(*) FROM favorite WHERE id=:id")
    suspend fun favControl(id:Int) : Int


    @Query("DELETE FROM favorite WHERE id = :id")
    suspend fun deleteFav(id: Int)

}