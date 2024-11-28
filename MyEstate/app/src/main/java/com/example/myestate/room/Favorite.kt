package com.example.myestate.room
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity
data class Favorite(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")  @NotNull   val id: Int,
    @ColumnInfo(name = "imageUrl")  @NotNull    val imageUrl:String,
    @ColumnInfo(name = "title") @NotNull    val title:String,
    @ColumnInfo(name = "city") @NotNull    val city:String,
    @ColumnInfo(name = "district") @NotNull     val district:String,
    @ColumnInfo(name = "price") @NotNull     val price:Int,
)