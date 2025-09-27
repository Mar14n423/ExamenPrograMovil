package com.example.examenprogramovil.features.dollar.domain.usecases

import com.example.examenprogramovil.features.dollar.domain.model.DollarModel
import com.example.examenprogramovil.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow

class FetchDollarUseCase(private val repository: IDollarRepository) {
    fun execute(): Flow<DollarModel> = repository.getDollar()
    suspend fun save(dollar: DollarModel) = repository.saveDollar(dollar)
}