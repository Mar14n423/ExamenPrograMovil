package com.example.examenprogramovil.features.github.domain.usercases

import com.example.examenprogramovil.features.github.domain.model.UserModel
import com.example.examenprogramovil.features.github.domain.repository.IgithubRepository

class FindByNickNameUseCase(val repository: IgithubRepository) {
    suspend fun invoke(nickName: String): Result<UserModel>{
        return repository.findbyNickName(nickName)
    }
}