package com.example.examenprogramovil.features.dollar.domain.model

data class DollarModel(
    val dollarOficialCompra: String? = null,
    val dollarOficialVenta: String? = null,
    val dollarParaleloCompra: String? = null,
    val dollarParaleloVenta: String? = null,
    val timestamp: Long = System.currentTimeMillis()
)