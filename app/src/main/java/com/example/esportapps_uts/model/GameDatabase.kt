package com.example.esportapps_uts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [User::class, Game::class, Achievement::class, Team::class, Proposal::class, Schedule::class], version = 6, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao
    abstract fun userDao(): UserDao
    abstract fun achievementDao(): AchievementDao
    abstract fun teamDao(): TeamDao
    abstract fun proposalDao(): ProposalDao
    abstract fun scheduleDao(): ScheduleDao


    companion object {
        @Volatile
        private var instance: GameDatabase? = null
        private val LOCK = Any()

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Game ADD COLUMN photoUrl TEXT")
            }
        }

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Achievement ADD COLUMN teamName TEXT")
            }
        }

        private val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("""
                    CREATE TABLE IF NOT EXISTS Team (
                        id_team INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        name TEXT NOT NULL,
                        role TEXT NOT NULL,
                        photoUrl TEXT,
                        teamGroup TEXT NOT NULL
                    )
                """)
            }
        }

        private val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("""
                    CREATE TABLE IF NOT EXISTS Proposal (
                        id_proposal INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        game_name TEXT NOT NULL,
                        team_name TEXT NOT NULL,
                        reason TEXT NOT NULL,
                        status TEXT NOT NULL
                    )
                """)
            }
        }
        private val MIGRATION_6_7 = object : Migration(6, 7) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE schedule ADD COLUMN example_column TEXT DEFAULT ''")
            }
        }


        fun getInstance(context: Context): GameDatabase {
            return instance ?: synchronized(LOCK) {
                instance ?: buildDB(context).also { instance = it }
            }
        }

        private fun buildDB(context: Context): GameDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                GameDatabase::class.java,
                "esport"
            )
                .addMigrations(
                    MIGRATION_1_2,
                    MIGRATION_2_3,
                    MIGRATION_3_4,
                    MIGRATION_4_5,
                    MIGRATION_6_7

                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
