package com.example.examenprogramovil.features.dollar.domain.usecases

import com.example.examenprogramovil.features.dollar.domain.model.DollarModel
import com.example.examenprogramovil.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow

class FetchDollarUseCase(val repository: IDollarRepository) {
    suspend fun invoke(): Flow<DollarModel> {
        return repository.getDollar()
    }
}