package com.example.examenprogramovil.features.dollar.data.repository

import com.example.examenprogramovil.features.dollar.data.datasource.RealTimeRemoteDataSource
import com.example.examenprogramovil.features.dollar.domain.model.DollarModel
import com.example.examenprogramovil.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow

class DollarRepository(val realTimeRemoteDataSource: RealTimeRemoteDataSource): IDollarRepository {
    override suspend fun getDollar(): Flow<DollarModel> {
        //return flow {
        //    emit(DollarModel("6.96", "12.6"))
        //}
        return realTimeRemoteDataSource.getDollarUpdates()
    }
}