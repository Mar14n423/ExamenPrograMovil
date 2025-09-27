package com.example.examenprogramovil.features.login.data.repository

import com.example.examenprogramovil.features.login.domain.model.UserLoginModel
import com.example.examenprogramovil.features.login.domain.repository.ILoginRepository

class LoginRepository: ILoginRepository {
    override fun login(username: String, password: String): Result<UserLoginModel> {
        // Aquí lo más simple posible: hardcodeamos credenciales
        return if (username == "admin" && password == "1234") {
            Result.success(UserLoginModel(username, "fake_token_12345"))
        } else {
            Result.failure(Exception("Credenciales incorrectas"))
        }
    }
}