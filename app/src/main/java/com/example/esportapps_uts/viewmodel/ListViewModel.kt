package com.example.esportapps_uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.global.Global
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application):AndroidViewModel(application)//,CoroutineScope
 {
    val gameLD = MutableLiveData<ArrayList<Game>>()
    val gameLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private val VOLLEY_TAG = "volley.game"
    private var queue: RequestQueue? = null
    //private var games  = Game()

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())

        val stringRequest = StringRequest(
            Request.Method.GET,
            "${Global.baseUrl}/game.json",
            { response ->
                Log.d("VolleyRequest.Game", response)
                val cleanedResponse = response.replace(" mph", "")
                this.gameLD.value = Gson().fromJson<List<Game>>(
                    cleanedResponse,
                    object : TypeToken<List<Game>>() {}.type,
                ) as ArrayList<Game>?
            },
            { error ->
                Log.d("VolleyRequest.Game", error.message.toString())
            },
        )

        stringRequest.tag = VOLLEY_TAG
        queue?.add(stringRequest)
        gameLoadErrorLD.value = false
        loadingLD.value = false

    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(VOLLEY_TAG)
    }
   // override val coroutineContext: CoroutineContext
        //get() = game + Dispatchers.IO

}