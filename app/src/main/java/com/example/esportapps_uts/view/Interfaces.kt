package com.example.esportapps_uts.view

import android.view.View
import com.example.esportapps_uts.model.Achievement
import com.example.esportapps_uts.model.Game

interface ButtonSignUpListener{
    fun onButtonSignUp(v: View)
}

interface ButtonBackListener{
    fun onButtonBack(v: View)
}

interface ButtonLoginListener{
    fun onButtonLogin(v: View)
}

interface TextCreateAccListener{
    fun onTextCreateAcc(v: View)
}

interface ButtonLogoutListener {
    fun onButtonLogout(v: View)
}

interface GameCardListener {
    fun onGameTeam(view: View, game: Game)
    fun onGameAchievements(view: View, game: Game)
}

interface ProgressBarListener {
    fun onProgressBarClick(view: View, state: Boolean, message: String?)
}
interface TeamDetailCardListener {
    fun onTeamClick(achievement: Achievement)
}