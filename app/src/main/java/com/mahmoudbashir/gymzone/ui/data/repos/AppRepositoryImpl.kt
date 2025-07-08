package com.mahmoudbashir.gymzone.ui.data.repos

import com.mahmoudbashir.gymzone.ui.data.models.ExerciseEntity
import com.mahmoudbashir.gymzone.ui.data.models.Player

class AppRepositoryImpl: AppRepository {
    override suspend fun addExercise(exercise: ExerciseEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getExerciseById(id: Int): ExerciseEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun updateExercise(exercise: ExerciseEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteExercise(exercise: ExerciseEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun addPlayer(player: Player) {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerById(id: Int): Player? {
        TODO("Not yet implemented")
    }

    override suspend fun updatePlayer(player: Player) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePlayer(player: Player) {
        TODO("Not yet implemented")
    }
}