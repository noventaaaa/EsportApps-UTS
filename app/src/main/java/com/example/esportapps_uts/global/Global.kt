package com.example.esportapps_uts.global

import android.content.Context
import androidx.appcompat.app.AlertDialog

class Global {
    companion object {
//        val baseUrl = "http://192.168.1.3/esport/"
        val baseUrl = "http://192.168.45.128/esport/"
        fun makeAlert(context: Context, title:String, message:String){
            val alert = AlertDialog.Builder(context)
            alert.setTitle(title)
            alert.setMessage(message)
            alert.setPositiveButton("OK") { _,_ ->}
            alert.show()
        }
    }
}