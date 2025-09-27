package com.example.examenprogramovil.features.movies.domain.usercases
import com.example.examenprogramovil.features.movies.domain.model.MovieModel
import com.example.examenprogramovil.features.movies.domain.repository.IMovieRepository

class InserteMyFavoriteMovieUseCase(
    private val repository: IMovieRepository
) {
    suspend operator fun invoke(movie: MovieModel): Unit {
        return repository.insertMyFavoriteMovie(movie)
    }
}