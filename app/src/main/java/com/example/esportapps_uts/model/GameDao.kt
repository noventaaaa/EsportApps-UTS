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

    @Query("SELECT * FROM game WHERE idgame = :id")
    fun selectGame(id: Int): Game

    @Delete
    fun deleteGame(game: Game)

    @Query("SELECT idgame FROM Game WHERE name = :name LIMIT 1")
    fun getGameIdByName(name: String): Int?

    @Query("SELECT name FROM Game WHERE idgame = :id LIMIT 1")
    fun getGameNameById(id: Int): String?
//
//    @Query("SELECT * FROM game")
//    fun getAllGames(): List<Game>
}

