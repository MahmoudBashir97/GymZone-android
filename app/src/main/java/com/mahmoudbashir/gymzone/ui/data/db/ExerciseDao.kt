package com.mahmoudbashir.gymzone.ui.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahmoudbashir.gymzone.ui.data.models.ExerciseEntity

@Dao
interface ExerciseDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertExercise(exercise: ExerciseEntity)

     @Query("SELECT * FROM exercises WHERE id = :id")
     suspend fun getExerciseById(id: Int): ExerciseEntity

     @Query("SELECT * FROM exercises")
     suspend fun getAllExercises(): List<ExerciseEntity>

     @Delete
     suspend fun deleteExercise(exercise: ExerciseEntity)
}