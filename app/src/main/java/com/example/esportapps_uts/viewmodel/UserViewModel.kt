package com.example.esportapps_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import com.example.esportapps_uts.util.buildDB
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application):AndroidViewModel(application), CoroutineScope {
    var userLD = MutableLiveData<User>()

    fun signUp(list: List<User>){
        launch {
            val db = buildDB(getApplication())
            db.userDao().insertAll(*list.toTypedArray())
        }
    }

    fun login(username:String, password:String){
        launch {
            val db = buildDB(getApplication())
            userLD.postValue(db.userDao().selectUser(username,password))
        }

    }

    fun fetch(username: String) {
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                val db = buildDB(getApplication())
                db.userDao().selectProfile(username)
            }
            userLD.postValue(user)
        }
    }

    fun update(name:String,password:String,id:Int){
        launch {
            val db = buildDB(getApplication())
            db.userDao().userUpdate(name,password,id)
        }
    }

    private val job = Job()
    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO
}
