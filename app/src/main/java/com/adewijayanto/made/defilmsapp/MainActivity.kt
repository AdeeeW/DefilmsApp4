package com.adewijayanto.made.defilmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.adewijayanto.made.defilmsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val navHostFragment: Fragment =
            supportFragmentManager.findFragmentById(R.id.nav_container) as NavHostFragment
        mController = navHostFragment.findNavController()

        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(
            R.id.menu_movie,
            R.id.menu_tv_show,
            R.id.menu_favorite,
            R.id.menu_settings
        ).build()

        setupActionBarWithNavController(mController, appBarConfiguration)
        activityMainBinding.apply {
            navButton.setupWithNavController(mController)
        }
    }
}