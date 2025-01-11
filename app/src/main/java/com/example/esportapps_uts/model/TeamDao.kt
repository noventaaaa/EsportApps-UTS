package com.example.esportapps_uts.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TeamDao {
    @Query("""
        SELECT t.*
        FROM Team t
        INNER JOIN Achievement a ON t.teamGroup = a.team
        WHERE a.team = :teamGroup
    """)
    fun getTeamDetailsByGroup(teamGroup: String): LiveData<List<Team>>

    @Insert
    fun insertAll(vararg teams: Team)

    @Query("SELECT * FROM Team")
    fun getAllTeams(): List<Team>

    @Query("SELECT * FROM Team WHERE teamGroup = :teamGroup")
    fun getTeamsByGroup(teamGroup: String): List<Team>

    @Query("SELECT DISTINCT teamGroup FROM Team")
    fun getTeam(): List<String>

}
