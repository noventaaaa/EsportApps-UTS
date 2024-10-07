package com.example.esportapps_uts.view

import android.os.Bundle
import android.view.MenuInflater
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.esportapps_uts.R
import com.example.esportapps_uts.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // change the argument of setContentView
//
//        navController =
//            (supportFragmentManager.findFragmentById(R.id.fragmentHost) as
//                    NavHostFragment).navController
//        NavigationUI.setupActionBarWithNavController(this, navController)
//        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
//        NavigationUI.setupWithNavController(bottomNav, navController)

//        navController = (supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment).navController
//        NavigationUI.setupActionBarWithNavController(this, navController)
//        binding.bottomNav.setupWithNavController(navController)


    }
//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, drawerLayout)
//                || super.onSupportNavigateUp()
//    }





//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
//


}