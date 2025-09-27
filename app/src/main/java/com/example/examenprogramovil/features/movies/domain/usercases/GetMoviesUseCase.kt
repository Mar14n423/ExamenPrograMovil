package com.example.examenprogramovil.features.movies.domain.usercases

import com.example.examenprogramovil.features.movies.domain.model.MovieModel
import com.example.examenprogramovil.features.movies.domain.repository.IMovieRepository

class GetMoviesUseCase(val repository: IMovieRepository) {
    suspend fun invoke(): Result<List<MovieModel>>{
        return repository.getMovies()
    }
}