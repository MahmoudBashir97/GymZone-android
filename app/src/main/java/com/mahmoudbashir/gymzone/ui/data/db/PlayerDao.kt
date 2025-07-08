package com.mahmoudbashir.gymzone.ui.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahmoudbashir.gymzone.ui.data.models.Player

@Dao
interface PlayerDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertPlayer(player: Player)

     @Query("SELECT * FROM players WHERE id = :id")
     suspend fun getPlayerById(id: Int): Player

     @Query("SELECT * FROM players")
     suspend fun getAllPlayers(): List<Player>

     @Delete
     suspend fun deletePlayer(player: Player)
}