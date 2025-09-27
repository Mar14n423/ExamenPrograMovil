package com.example.examenprogramovil.features.movies.domain.usercases
import com.example.examenprogramovil.features.movies.domain.model.MovieModel
import com.example.examenprogramovil.features.movies.domain.repository.IMovieRepository

class GetPopularMoviesUseCase(
    private val repository: IMovieRepository
) {
    suspend operator fun invoke(page: Int): Result<List<MovieModel>> {
        return repository.getPopular(page)
    }
}