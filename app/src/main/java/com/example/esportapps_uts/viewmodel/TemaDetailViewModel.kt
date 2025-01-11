package com.example.esportapps_uts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.esportapps_uts.model.Team
import com.example.esportapps_uts.util.listTeams

class TeamDetailViewModel : ViewModel() {
    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> get() = _teams

    fun getTeamDetails(teamGroup: String) {
        _teams.value = listTeams.filter { it.teamGroup == teamGroup }
    }
}
