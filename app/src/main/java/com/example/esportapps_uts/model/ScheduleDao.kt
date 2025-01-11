package com.example.esportapps_uts.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg schedules: Schedule)

    @Query("SELECT * FROM schedule")
    fun getAllSchedules(): List<Schedule>
}
