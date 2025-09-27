package com.example.examenprogramovil.features.movies.data.repository

import com.example.examenprogramovil.features.movies.data.datasource.MovieLocalDataSource
import com.example.examenprogramovil.features.movies.domain.model.MovieModel
import com.example.examenprogramovil.features.movies.domain.repository.IMovieRepository
import com.example.examenprogramovil.features.movies.data.datasource.MoviesRemoteDataSource

private const val TMDB_IMAGE_BASE_W185 = "https://image.tmdb.org/t/p/w185"

class MoviesRepository(
    private val remote: MoviesRemoteDataSource,
    private val local: MovieLocalDataSource
) : IMovieRepository {

    override suspend fun getPopular(page: Int): Result<List<MovieModel>> {
        val response = remote.getPopularMovies(page)

        response.fold(
            onSuccess = { page ->
                var dtos = page.results
                var models = dtos.map { dto ->
                    MovieModel(
                        id = dto.id,
                        title = dto.title,
                        imageUrl = dto.backdropPath?.let { "$TMDB_IMAGE_BASE_W185$it" }
                    )
                }

                return Result.success(models)
            },
            onFailure = { exception -> return Result.failure(exception) }
        )
    }

    override suspend fun insertMyFavoriteMovie(movieModel: MovieModel): Unit {
        local.insertMovie(movieModel)
    }

    override suspend fun getFavorites(): List<MovieModel> {
        return local.getFavorites()
    }




}