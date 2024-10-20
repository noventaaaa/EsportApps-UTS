package com.example.esportapps_uts.model

data class Game(
    var id:String?,
    var name:String?,
    var description:String?,
    var photoUrl:String?
)

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