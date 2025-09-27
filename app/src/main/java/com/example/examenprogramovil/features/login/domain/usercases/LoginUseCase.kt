package com.example.examenprogramovil.features.login.domain.usercases

import com.example.examenprogramovil.features.login.domain.model.UserLoginModel
import com.example.examenprogramovil.features.login.domain.repository.ILoginRepository

class LoginUseCase(private val repository: ILoginRepository) {
    operator fun invoke(username: String, password: String): Result<UserLoginModel> {
        // Aquí puedes poner validaciones simples
        if (username.isBlank()) {
            return Result.failure(Exception("Usuario no puede estar vacío"))
        }
        if(password.isBlank()){
            return Result.failure(Exception("contraseña no puede estar vacío"))
        }

        return repository.login(username, password)
    }
}