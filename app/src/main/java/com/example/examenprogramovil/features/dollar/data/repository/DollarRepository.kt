package com.example.examenprogramovil.features.dollar.data.repository

import com.example.examenprogramovil.features.dollar.data.database.dao.IDollarDao
import com.example.examenprogramovil.features.dollar.domain.model.DollarModel
import com.example.examenprogramovil.features.dollar.domain.repository.IDollarRepository
import com.example.examenprogramovil.features.dollar.data.mapper.toEntity
import com.example.examenprogramovil.features.dollar.data.mapper.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DollarRepository(
    private val dao: IDollarDao
) : IDollarRepository {

    override fun getDollar(): Flow<DollarModel> {
        return dao.getLastDollar().map { entity ->
            entity?.toModel() ?: DollarModel( // Si no hay nada en la BD devolvemos dummy
                dollarOficialCompra = "--",
                dollarOficialVenta = "--",
                dollarParaleloCompra = "--",
                dollarParaleloVenta = "--",
                timestamp = System.currentTimeMillis()
            )
        }
    }

    override suspend fun saveDollar(dollar: DollarModel) {
        dao.insertDollar(dollar.toEntity())
    }
}