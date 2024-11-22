package com.example.esportapps_uts.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import com.example.esportapps_uts.R
import com.example.esportapps_uts.model.GameDatabase
import com.squareup.picasso.Picasso
import javax.security.auth.callback.Callback

val DB_NAME = "esport"

fun buildDB(context: Context):GameDatabase{
    val db = Room.databaseBuilder(
        context,
        GameDatabase::class.java,
        DB_NAME
    ).build()

    return db
}
fun ImageView.loadImage(url: String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .centerCrop()
        .resize(400,300)
        .error(R.drawable.baseline_person_24)
        .into(this, object: com.squareup.picasso.Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
                progressBar.visibility = View.GONE
            }
        })
}

@BindingAdapter("android:imageUrl")
fun loadPhotoUrl(view: ImageView, url:String){
    view.loadImage(url, progressBar )
}
