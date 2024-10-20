package com.example.esportapps_uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.example.esportapps_uts.model.Game

import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.esportapps_uts.global.Global
import com.example.esportapps_uts.model.Schedule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListScheduleViewModel(application: Application):AndroidViewModel(application) {
    val scheduleLD = MutableLiveData<ArrayList<Schedule>>()
    val scheduleLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private val VOLLEY_TAG = "volley.schedule"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())

        val stringRequest = StringRequest(
            Request.Method.GET,
            "${Global.baseUrl}/schedule.json",
            { response ->
                Log.d("VolleyRequest.Schedule", response)
                val cleanedResponse = response.replace(" mph", "")
                this.scheduleLD.value = Gson().fromJson<List<Schedule>>(
                    cleanedResponse,
                    object : TypeToken<List<Schedule>>() {}.type,
                ) as ArrayList<Schedule>?
            },
            { error ->
                Log.d("VolleyRequest.Schedule", error.message.toString())
            },
        )

        stringRequest.tag = VOLLEY_TAG
        queue?.add(stringRequest)
        scheduleLoadErrorLD.value = false
        loadingLD.value = false

    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(VOLLEY_TAG)
    }
}