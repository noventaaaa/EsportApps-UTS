package com.example.esportapps_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.esportapps_uts.model.User
import com.example.esportapps_uts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    var userLD = MutableLiveData<User?>()

    fun signUp(list: List<User>) {
        launch {
            val db = buildDB(getApplication())
            db.userDao().insertAll(*list.toTypedArray())
        }
    }

    fun login(username: String, password: String) {
        launch {
            val db = buildDB(getApplication())
            userLD.postValue(db.userDao().selectUser(username, password))
        }
    }

    fun checkUsernameUnique(username: String): LiveData<Boolean> {
        val isUniqueLD = MutableLiveData<Boolean>()
        launch {
            val db = buildDB(getApplication())
            val count = db.userDao().isUsernameUnique(username)
            isUniqueLD.postValue(count == 0)
        }
        return isUniqueLD
    }

    fun getUserByUsername(username: String) {
        launch {
            val db = buildDB(getApplication())
            val user = db.userDao().selectUserByUsername(username)
            userLD.postValue(user)
        }
    }






    private val job = Job()
    override val coroutineContext: CoroutineContext get() = job + Dispatchers.IO
}
