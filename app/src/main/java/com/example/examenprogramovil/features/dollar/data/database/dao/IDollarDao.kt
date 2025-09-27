package com.example.examenprogramovil.features.dollar.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenprogramovil.features.dollar.data.database.entity.DollarEntity

@Dao
interface DollarDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dollar: DollarEntity)

    @Query("SELECT * FROM dollars ORDER BY timestamp DESC")
    suspend fun getAll(): List<DollarEntity>
}