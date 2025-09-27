package com.example.examenprogramovil.features.github.domain.repository

import com.example.examenprogramovil.features.github.domain.model.UserModel

interface IgithubRepository {
    suspend fun findbyNickName(value: String): Result<UserModel>
}