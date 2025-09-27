package com.example.examenprogramovil.features.dollar.data.mapper

import com.example.examenprogramovil.features.dollar.data.database.entity.DollarEntity
import com.example.examenprogramovil.features.dollar.domain.model.DollarModel

fun DollarEntity.toModel(): DollarModel {
    return DollarModel(
        dollarOficialCompra = dollarOficialCompra,
        dollarOficialVenta = dollarOficialVenta,
        dollarParaleloCompra = dollarParaleloCompra,
        dollarParaleloVenta = dollarParaleloVenta,
        timestamp = timestamp
    )
}

fun DollarModel.toEntity(): DollarEntity {
    return DollarEntity(
        dollarOficialCompra = dollarOficialCompra,
        dollarOficialVenta = dollarOficialVenta,
        dollarParaleloCompra = dollarParaleloCompra,
        dollarParaleloVenta = dollarParaleloVenta,
        timestamp = System.currentTimeMillis()
    )
}