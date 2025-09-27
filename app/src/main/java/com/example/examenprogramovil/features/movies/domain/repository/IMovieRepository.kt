package com.example.examenprogramovil.features.movies.domain.repository

import com.example.examenprogramovil.features.movies.domain.model.MovieModel

interface IMovieRepository {
    suspend fun getMovies(): Result<List<MovieModel>>
}