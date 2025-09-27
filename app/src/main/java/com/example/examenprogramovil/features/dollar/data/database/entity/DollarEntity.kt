package com.example.examenprogramovil.features.dollar.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dollars")
data class DollarEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,

    @ColumnInfo(name = "oficial_compra") val dollarOficialCompra: String? = null,
    @ColumnInfo(name = "oficial_venta") val dollarOficialVenta: String? = null,
    @ColumnInfo(name = "paralelo_compra") val dollarParaleloCompra: String? = null,
    @ColumnInfo(name = "paralelo_venta") val dollarParaleloVenta: String? = null,

    @ColumnInfo(name = "timestamp") val timestamp: Long = System.currentTimeMillis()
)