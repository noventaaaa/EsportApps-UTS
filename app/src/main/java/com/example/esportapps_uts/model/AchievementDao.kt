package com.example.esportapps_uts.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.esportapps_uts.util.buildDB

@Dao
interface AchievementDao {
    @Query("SELECT * FROM Achievement WHERE idgame = :idgame")
    fun getAchievementsByGameId(idgame: Int): LiveData<List<Achievement>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg achievements: Achievement)
}
