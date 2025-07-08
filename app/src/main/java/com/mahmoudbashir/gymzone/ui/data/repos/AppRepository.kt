package com.mahmoudbashir.gymzone.ui.data.repos

import com.mahmoudbashir.gymzone.ui.data.models.ExerciseEntity
import com.mahmoudbashir.gymzone.ui.data.models.Player

interface AppRepository {
    suspend fun addExercise(exercise: ExerciseEntity)
    suspend fun getExerciseById(id: Int): ExerciseEntity?
    suspend fun updateExercise(exercise: ExerciseEntity)
    suspend fun deleteExercise(exercise: ExerciseEntity)

    suspend fun addPlayer(player: Player)
    suspend fun getPlayerById(id: Int): Player?
    suspend fun updatePlayer(player: Player)
    suspend fun deletePlayer(player: Player)
}