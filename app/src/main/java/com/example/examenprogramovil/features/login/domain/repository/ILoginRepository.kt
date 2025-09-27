package com.example.examenprogramovil.features.login.domain.repository

import com.example.examenprogramovil.features.login.domain.model.UserLoginModel

interface ILoginRepository {
    fun login(username: String, password: String): Result<UserLoginModel>
}