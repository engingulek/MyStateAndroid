package com.example.myestate.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    suspend fun allFavorite() : List<Favorite>

  /*  @Insert
    suspend fun addAdvertToFav(fav:Favorite)

    @Delete
    suspend fun deleteFac(fav:Favorite)


    @Query("SELECT count(*) FROM favorite WHERE id=:id")
    suspend fun favControl(id:Int) : Int*/
}