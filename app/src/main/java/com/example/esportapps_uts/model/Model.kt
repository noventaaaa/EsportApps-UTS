package com.example.esportapps_uts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "description")
    var description: String?,
    @ColumnInfo(name = "photoUrl")
    var photoUrl: String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idgame")
    var idgame: Int = 0
}


@Entity
data class User(
    @ColumnInfo(name = "first_name")
    var firstname: String,
    @ColumnInfo(name = "last_name")
    var lastname: String,
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "password")
    var password: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "iduser")
    var iduser: Int = 0
}

@Entity
data class Achievement(
    @ColumnInfo(name = "idgame")
    var idgame: Int,
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "description")
    var description: String?,
    @ColumnInfo(name = "year")
    var year: Int?,
    @ColumnInfo(name = "team")
    var team: String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idachievement")
    var idachievement: Int = 0

    fun getFormattedDescription(): String {
        return "$description ($year) - $team"
    }
}

@Entity
data class Team(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "role") val role: String,
    @ColumnInfo(name = "photoUrl") val photoUrl: String? = null,
    @ColumnInfo(name = "teamGroup") val teamGroup: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_team")
    var idTeam: Int = 0
}



@Entity
data class ApplyTeam(
    @ColumnInfo(name = "game_name") val gameName: String,
    @ColumnInfo(name = "team_name") val teamName: String,
    @ColumnInfo(name = "description") val description: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_apply_team")
    var idApplyTeam: Int = 0
}


@Entity
data class Proposal(
    @ColumnInfo(name = "game_name")
    var gameName: String,
    @ColumnInfo(name = "team_name")
    var teamName: String,
    @ColumnInfo(name = "reason")
    var reason: String,
    @ColumnInfo(name = "status")
    var status: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_proposal")
    var idProposal: Int = 0
}


@Entity
data class Schedule(
    @ColumnInfo(name = "event_date")
    var eventDate: String,
    @ColumnInfo(name = "event_month")
    var eventMonth: String,
    @ColumnInfo(name = "event_name")
    var eventName: String,
    @ColumnInfo(name = "team_name")
    var teamName: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_schedule")
    var idSchedule: Int = 0
}

