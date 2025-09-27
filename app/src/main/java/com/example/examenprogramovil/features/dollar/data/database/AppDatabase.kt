package com.example.examenprogramovil.features.dollar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examenprogramovil.features.dollar.data.database.dao.DollarDao
import com.example.examenprogramovil.features.dollar.data.database.entity.DollarEntity

@Database(
    entities = [DollarEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dollarDao(): DollarDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "dollar_db"
                )
                    .fallbackToDestructiveMigration() // rápido para examen
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}