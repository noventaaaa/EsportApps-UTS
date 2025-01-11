package com.example.esportapps_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.esportapps_uts.model.Achievement
import com.example.esportapps_uts.util.buildDB
import com.example.esportapps_uts.util.listAchievements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AchievementViewModel(application: Application) : AndroidViewModel(application) {

    val achievementsLD = MutableLiveData<List<Achievement>>()
    val loadingLD = MutableLiveData<Boolean>()
    val errorLD = MutableLiveData<Boolean>()

    fun addAchievements(list: List<Achievement>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val db = buildDB(getApplication())
                db.achievementDao().insertAll(*list.toTypedArray())
                println("Achievements successfully added: ${list.size}")
            } catch (e: Exception) {
                errorLD.postValue(true)
                println("Error adding achievements: ${e.message}")
            }
        }
    }

    fun refresh(gameId: Int) {
        loadingLD.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val db = buildDB(getApplication())
                var achievementList = db.achievementDao().getAchievementsByGameId(gameId).value ?: emptyList()

                if (achievementList.isEmpty()) {
                    db.achievementDao().insertAll(*listAchievements.toTypedArray())
                    achievementList = db.achievementDao().getAchievementsByGameId(gameId).value ?: emptyList()
                    println("Placeholder achievements added: ${listAchievements.size}")
                }

                achievementsLD.postValue(achievementList)
                errorLD.postValue(false)
                println("Achievements loaded from database: ${achievementList.size}")
            } catch (e: Exception) {
                errorLD.postValue(true)
                println("Error loading achievements: ${e.message}")
            } finally {
                loadingLD.postValue(false)
            }
        }
    }
}
