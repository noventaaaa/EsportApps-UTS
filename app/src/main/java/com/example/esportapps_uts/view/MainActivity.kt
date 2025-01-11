//package com.example.esportapps_uts.view
//
//import android.content.Context
//import android.os.Bundle
//import android.view.MenuItem
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.navigation.NavController
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.ui.NavigationUI
//import androidx.navigation.ui.setupWithNavController
//import androidx.viewpager2.widget.ViewPager2
//import com.example.esportapps_uts.R
//import com.google.android.material.navigation.NavigationView
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var navController: NavController
//    private lateinit var bottomNav: BottomNavigationView
//    private lateinit var viewPager: ViewPager2
//
//    companion object {
//        const val EXTRA_USERNAME = "USERNAME"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        drawerLayout = findViewById(R.id.drawerLayout)
//
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
//        navController = navHostFragment.navController
//
//        val navView = findViewById<NavigationView>(R.id.navView)
//        navView.setupWithNavController(navController)
//
//        bottomNav = findViewById(R.id.bottomNav)
//        bottomNav.setupWithNavController(navController)
//
//        setupNavHeader(navView)
//
////        viewPager.adapter = ViewPagerAdapter(this)
//
////        bottomNav.setOnItemSelectedListener { menuItem ->
////            when (menuItem.itemId) {
////                R.id.itemGameList -> viewPager.currentItem = 0
////                R.id.itemSchedule -> viewPager.currentItem = 1
////                R.id.itemProfile -> viewPager.currentItem = 2
////                else -> false
////            }
////            true
////        }
//
//        navView.setNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.menu_apply_team -> {
//                    navController.navigate(R.id.proposalListFragment)
//                    true
//                }
//                R.id.menu_profile -> {
//                    navController.navigate(R.id.myProfileFragment)
//                    true
//                }
//                R.id.menu_sign_out -> {
//                    val sharedFile = packageName
//                    val shared = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
//                    val editor = shared.edit()
//                    editor.clear()
//                    editor.apply()
//
//                    Toast.makeText(this, "You have been logged out.", Toast.LENGTH_SHORT).show()
//                    navController.navigate(R.id.loginFragment)
//                    true
//                }
//                else -> false
//            }.also {
//                drawerLayout.closeDrawers()
//            }
//        }
//
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.loginFragment, R.id.signUpFragment -> {
//                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
//                    bottomNav.visibility = View.GONE
//                }
//                else -> {
//                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
//                    bottomNav.visibility = View.VISIBLE
//                    setupNavHeader(navView)
//                }
//            }
//        }
//    }
//
//    private fun setupNavHeader(navView: NavigationView) {
//        val headerView = navView.getHeaderView(0)
//        val tvWelcome = headerView.findViewById<TextView>(R.id.tvWelcome)
//        val imgProfile = headerView.findViewById<ImageView>(R.id.imgProfile)
//
//        val sharedFile = packageName
//        val shared = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
//        val username = shared.getString(EXTRA_USERNAME, "Guest")
//
//        tvWelcome.text = "Welcome, $username"
//        imgProfile.setImageResource(R.drawable.baseline_person_24)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (NavigationUI.onNavDestinationSelected(item, navController)) {
//            true
//        } else {
//            super.onOptionsItemSelected(item)
//        }
//    }
//}

package com.example.esportapps_uts.view

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.esportapps_uts.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView

    companion object {
        const val EXTRA_USERNAME = "USERNAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.proposalListFragment,
                R.id.myProfileFragment
            ),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        setupNavHeader(navView)

        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_apply_team -> {
                    navController.navigate(R.id.proposalListFragment)
                    true
                }
                R.id.menu_profile -> {
                    navController.navigate(R.id.myProfileFragment)
                    true
                }
                R.id.menu_sign_out -> {
                    val sharedFile = packageName
                    val shared = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
                    val editor = shared.edit()
                    editor.clear()
                    editor.apply()

                    Toast.makeText(this, "You have been logged out.", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.loginFragment)
                    true
                }
                else -> false
            }.also {
                drawerLayout.closeDrawers()
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.applyTeamFragment -> supportActionBar?.title = "Home"
                R.id.myProfileFragment -> supportActionBar?.title = "Profile"
                R.id.loginFragment, R.id.signUpFragment -> {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                    bottomNav.visibility = android.view.View.GONE
                    supportActionBar?.title = "Login"
                }
                else -> {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                    bottomNav.visibility = android.view.View.VISIBLE
                    supportActionBar?.title = "eSport App"
                }
            }
        }
    }

    private fun setupNavHeader(navView: NavigationView) {
        val headerView = navView.getHeaderView(0)
        val tvWelcome = headerView.findViewById<TextView>(R.id.tvWelcome)
        val imgProfile = headerView.findViewById<ImageView>(R.id.imgProfile)

        val sharedFile = packageName
        val shared = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        val username = shared.getString(EXTRA_USERNAME, "Guest")

        tvWelcome.text = "Welcome, $username"
        imgProfile.setImageResource(R.drawable.baseline_person_24)
    }

    private fun handleSignOut() {
        val sharedFile = packageName
        val shared = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        shared.edit().clear().apply()

        Toast.makeText(this, "You have been logged out.", Toast.LENGTH_SHORT).show()
        navController.navigate(R.id.loginFragment)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}


