package com.example.examenprogramovil.features.movies.data.mapper


import com.example.examenprogramovil.features.movies.data.database.entity.MovieEntity
import com.example.examenprogramovil.features.movies.domain.model.MovieModel

fun MovieEntity.toModel() : MovieModel {
    return MovieModel(
        id = id,
        title = title,
        imageUrl = imageUrl,
        isFavorite = isFavorite
    )
}


fun MovieModel.toEntity() : MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        imageUrl = imageUrl,
        isFavorite = isFavorite
    )
}