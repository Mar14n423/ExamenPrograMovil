package com.example.examenprogramovil.features.movies.data.api

import com.example.examenprogramovil.features.movies.data.api.dto.MoviePageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("api_key") apiKey: String
    ): Response<MoviePageDto>
}