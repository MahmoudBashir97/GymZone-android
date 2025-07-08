package com.mahmoudbashir.gymzone.ui.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "players")
data class Player(
    @PrimaryKey()
    val id: Int = UUID.randomUUID().toString().toInt(),
    val name: String = "",
    val age: Int = 0,
    val height: String = "",
    val weight: String = "",
)
