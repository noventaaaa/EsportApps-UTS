package com.example.esportapps_uts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class,Game::class), version =  1)
abstract class GameDatabase:RoomDatabase() {
    abstract fun gameDao():GameDao
    abstract fun userDao():UserDao

    companion object {
        @Volatile private var instance: GameDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                GameDatabase::class.java,
                "newgamedb").build()

        operator fun invoke(context:Context) {
            if(instance == null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}
