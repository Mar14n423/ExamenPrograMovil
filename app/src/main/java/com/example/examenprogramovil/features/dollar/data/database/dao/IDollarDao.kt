package com.example.examenprogramovil.features.dollar.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenprogramovil.features.dollar.data.database.entity.DollarEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IDollarDao {
    @Query("SELECT * FROM dollars ORDER BY timestamp DESC LIMIT 1")
    fun getLastDollar(): Flow<DollarEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDollar(dollar: DollarEntity)
}