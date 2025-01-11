package com.example.esportapps_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.util.buildDB
import com.example.esportapps_uts.util.listWePlay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    val gamesLD = MutableLiveData<List<Game>>()
    val loadingLD = MutableLiveData<Boolean>()
    val errorLD = MutableLiveData<Boolean>()

    fun addGames(list: List<Game>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val db = buildDB(getApplication())
                db.gameDao().insertAll(*list.toTypedArray())
                println("Games successfully added: ${list.size}")
            } catch (e: Exception) {
                errorLD.postValue(true)
                println("Error adding games: ${e.message}")
            }
        }
    }

    fun refresh() {
        loadingLD.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val db = buildDB(getApplication())
                var gameList = db.gameDao().selectAllGame()

                if (gameList.isEmpty()) {
                    db.gameDao().insertAll(*listWePlay.toTypedArray())
                    gameList = db.gameDao().selectAllGame()
                    println("Placeholder games added: ${listWePlay.size}")
                }

                gamesLD.postValue(gameList)
                errorLD.postValue(false)
                println("Games loaded from database: ${gameList.size}")
            } catch (e: Exception) {
                errorLD.postValue(true)
                println("Error loading games: ${e.message}")
            } finally {
                loadingLD.postValue(false)
            }
        }
    }
}
