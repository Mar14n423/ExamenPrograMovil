package com.example.examenprogramovil.features.movies.domain.usercases

import com.example.examenprogramovil.features.movies.domain.model.MovieModel
import com.example.examenprogramovil.features.movies.domain.repository.IMovieRepository

class GetFavoritesUseCase(
    private val repository: IMovieRepository
) {
    suspend operator fun invoke(): List<MovieModel> {
        return repository.getFavorites()
    }
}