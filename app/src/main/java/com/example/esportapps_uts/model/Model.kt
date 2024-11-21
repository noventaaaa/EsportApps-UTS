package com.example.esportapps_uts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @ColumnInfo(name="id")
    var id:String?,
    @ColumnInfo(name="name")
    var name:String?,
    @ColumnInfo(name = "description")
    var description:String?,
    @ColumnInfo(name="photoUrl")
    var photoUrl:String?
) {
    @PrimaryKey(autoGenerate = true)
    var idgame:Int = 0
}
@Entity
data class User(
    @ColumnInfo(name = "first_name")
    var firstname:String,
    @ColumnInfo(name = "last_name")
    var lasttname:String,
    @ColumnInfo(name = "username")
    var username:String,
    @ColumnInfo(name = "password")
    var password:String,
){
    @PrimaryKey(autoGenerate = true)
    var iduser:Int = 0
}

data class Team(
    var id:String?,
    var name:String?,
    var description:String?,
    var photoUrl:String?
)

data class Member(
    var id:String?,
    var name:String?,
    var description:String?,
    var photoUrl:String?
)

data class Achievement(
    var id:String?,
    var name:String?,
    var description:String?,
)
data class Schedule(
    var id:String?,
    var date:String?,
    var month:String?,
    var event:String?,
    var location:String?,
    var time:String?,
    var game:String?,
    var team:String?,
    var description:String?
)

