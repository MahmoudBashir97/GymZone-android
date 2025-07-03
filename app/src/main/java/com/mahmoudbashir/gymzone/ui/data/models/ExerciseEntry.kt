package com.mahmoudbashir.gymzone.ui.data.models

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