package com.example.examenprogramovil.features.github.data.repository

import com.example.examenprogramovil.features.github.data.datasourse.GithubRemoteDataSource
import com.example.examenprogramovil.features.github.domain.model.UserModel
import com.example.examenprogramovil.features.github.domain.repository.IgithubRepository

class GithubRepository(val remoteDataSource: GithubRemoteDataSource
): IgithubRepository {
    override suspend fun findbyNickName(value: String): Result<UserModel> {
        if(value.isEmpty()) {
            return Result.failure(Exception("El campo no puede estar vacio"))
        }
        val response = remoteDataSource.getUser(value)

        response.fold(
            onSuccess = {
                    it ->
                return Result.success(UserModel(
                    nickName = it.login,
                    pathURL = it.url
                ))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

}

