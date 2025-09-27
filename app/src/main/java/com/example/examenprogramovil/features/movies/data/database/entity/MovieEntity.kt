package com.example.examenprogramovil.features.movies.data.database.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id: Long = 0,


    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean,

    )