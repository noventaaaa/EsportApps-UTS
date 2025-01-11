package com.example.esportapps_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.esportapps_uts.model.GameDatabase
import com.example.esportapps_uts.model.Schedule
import com.example.esportapps_uts.util.listSchedule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ScheduleViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO

    val scheduleLD = MutableLiveData<List<Schedule>>()

    init {
        populateSchedules()
    }

    private fun populateSchedules() {
        launch {
            val db = GameDatabase.getInstance(getApplication())
            if (db.scheduleDao().getAllSchedules().isEmpty()) {
                db.scheduleDao().insertAll(*listSchedule.toTypedArray())
            }
            scheduleLD.postValue(db.scheduleDao().getAllSchedules())
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}