package com.example.myestate.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorite::class], version = 1)
abstract class RoomDb : RoomDatabase(){
    abstract fun getFavoriteDao() : FavoriteDao

}