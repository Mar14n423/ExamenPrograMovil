package com.example.examenprogramovil.features.dollar.domain.repository

import com.example.examenprogramovil.features.dollar.domain.model.DollarModel
import kotlinx.coroutines.flow.Flow

interface IDollarRepository {
    fun getDollar(): Flow<DollarModel>
    suspend fun saveDollar(dollar: DollarModel)
}