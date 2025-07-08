package com.mahmoudbashir.gymzone.ui.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahmoudbashir.gymzone.ui.data.models.ExerciseEntity
import com.mahmoudbashir.gymzone.ui.data.models.Player

@Database(entities = [Player::class, ExerciseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun playerDao(): PlayerDao

    companion object {
        const val DATABASE_NAME = "gymzone_database"
    }
}