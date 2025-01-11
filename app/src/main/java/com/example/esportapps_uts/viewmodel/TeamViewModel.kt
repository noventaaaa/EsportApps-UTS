package com.example.esportapps_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.esportapps_uts.util.listAchievements
import kotlinx.coroutines.launch

class TeamViewModel(application: Application) : AndroidViewModel(application) {

    val teamsLD = MutableLiveData<List<String>>()
    val loadingLD = MutableLiveData<Boolean>()
    val errorLD = MutableLiveData<Boolean>()

    fun refresh(idgame: Int) {
        loadingLD.postValue(true)
        viewModelScope.launch {
            try {
                val teamNames = listAchievements
                    .filter { it.idgame == idgame }
                    .mapNotNull { it.team }
                    .distinct()

                teamsLD.postValue(teamNames)
                errorLD.postValue(false)
            } catch (e: Exception) {
                errorLD.postValue(true)
            } finally {
                loadingLD.postValue(false)
            }
        }
    }
}
