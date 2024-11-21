package com.example.esportapps_uts.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg game: Game)

    @Query("SELECT * FROM game")
    fun selectAllGame(): List<Game>

    @Query("SELECT * FROM game WHERE id= :id")
    fun selectGame(id:Int): Game

    @Delete
    fun deleteGame(game: Game)
}
