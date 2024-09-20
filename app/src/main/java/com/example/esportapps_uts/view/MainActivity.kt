package com.example.esportapps_uts.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.esportapps_uts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // change the argument of setContentView
    }

}