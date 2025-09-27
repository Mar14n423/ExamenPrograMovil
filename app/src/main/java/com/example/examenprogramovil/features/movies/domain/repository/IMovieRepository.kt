package com.example.examenprogramovil.features.movies.domain.repository

import com.example.examenprogramovil.features.movies.domain.model.MovieModel

interface IMovieRepository {
    suspend fun getPopular(page: Int): Result<List<MovieModel>>
    suspend fun insertMyFavoriteMovie(movieModel: MovieModel): Unit
    suspend fun getFavorites(): List<MovieModel>
}