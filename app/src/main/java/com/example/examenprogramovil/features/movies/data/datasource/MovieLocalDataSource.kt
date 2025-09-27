package com.example.examenprogramovil.features.movies.data.datasource

import com.example.examenprogramovil.features.movies.data.database.dao.IMovieDao
import com.example.examenprogramovil.features.movies.data.mapper.toEntity
import com.example.examenprogramovil.features.movies.data.mapper.toModel
import com.example.examenprogramovil.features.movies.domain.model.MovieModel

class MovieLocalDataSource(
    val dao: IMovieDao
) {


    suspend fun insertMovies(list: List<MovieModel>) {
        val moviesEntities = list.map { it.toEntity() }
        dao.insertMovies(moviesEntities)
    }

    suspend fun insertMovie(movieModel: MovieModel) {
        val movieEntity = movieModel.toEntity()
        dao.insertMovie(movieEntity)
    }

    suspend fun getFavorites(): List<MovieModel> {
        return dao.getFavorites().map { it.toModel() }
    }



}