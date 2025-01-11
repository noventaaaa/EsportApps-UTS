package com.example.esportapps_uts.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.model.GameDatabase
import com.example.esportapps_uts.model.Proposal
import com.example.esportapps_uts.model.Team
import kotlinx.coroutines.*

class ApplyTeamViewModel(application: Application) : AndroidViewModel(application) {

    private val gameDao = GameDatabase.getInstance(application).gameDao()
    private val teamDao = GameDatabase.getInstance(application).teamDao()
    private val proposalDao = GameDatabase.getInstance(application).proposalDao()
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val gamesLiveData = MutableLiveData<List<Game>>()
    val teamsLiveData = MutableLiveData<List<String>>()

    fun getGames() {
        uiScope.launch {
            val games = withContext(Dispatchers.IO) {
                gameDao.selectAllGame()
            }
            gamesLiveData.postValue(games)
        }
    }

    fun insertTeamsToDatabase(listTeams: List<Team>) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                teamDao.insertAll(*listTeams.toTypedArray())
            }
        }
    }

    fun getAllTeamGroups() {
        uiScope.launch {
            val teamGroups = withContext(Dispatchers.IO) {
                teamDao.getTeam()
            }
            Log.d("ApplyTeamViewModel", "Team Groups: $teamGroups")
            teamsLiveData.postValue(teamGroups)
        }
    }

    fun insertProposal(proposal: Proposal) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                proposalDao.insertProposal(proposal)
            }
            Log.d("ApplyTeamViewModel", "Proposal inserted: $proposal")
        }
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}