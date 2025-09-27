package com.example.examenprogramovil.features.movies.domain.model

data class MovieModel(
    val id: Long,
    val title: String?,
    val imageUrl: String?,
    val isFavorite: Boolean = false
)