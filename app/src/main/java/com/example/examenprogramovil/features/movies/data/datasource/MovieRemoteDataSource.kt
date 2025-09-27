package com.example.examenprogramovil.features.movies.data.datasource

import com.example.examenprogramovil.features.movies.data.api.MovieService
import com.example.examenprogramovil.features.movies.data.api.dto.DiscoverPageDto

class MoviesRemoteDataSource(
    private val service: MovieService
) {
    suspend fun getPopularMovies(page: Int): Result<DiscoverPageDto> {
        val response = service.discoverMovies(page = page)
        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Exception("Error al obtener la pagina de peliculas"))
        }
    }


}