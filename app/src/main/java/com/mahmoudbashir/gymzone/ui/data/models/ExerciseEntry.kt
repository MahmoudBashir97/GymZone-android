package com.mahmoudbashir.gymzone.ui.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

data class ExerciseEntry(
    val id: Long = Random.nextLong(),
    val exercise: String = "",
    val sets: Int = 0,
    val reps: Int = 0,
    val weight: String = "",
    val repTime: String = "",
    val notes: String = ""
)

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val exercise: String = "",
    val sets: Int = 0,
    val reps: Int = 0,
    val weight: String = "",
    val repTime: String = "",
    val notes: String = "",
    val playerId: Long = 0
)