package com.example.esportapps_uts.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.esportapps_uts.R
import com.squareup.picasso.Picasso
import javax.security.auth.callback.Callback

fun ImageView.loadImage(url: String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .centerCrop()
        .resize(400,300)
        .error(R.drawable.baseline_person_24)
        .into(this)
}