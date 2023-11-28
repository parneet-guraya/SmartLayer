package com.parneet.smartlayer.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.ActivityMainBinding

const val LOG_TAG = "MYCUSTOMLOGTAG"

fun logDebug(message: String) {
    Log.d(LOG_TAG, message)
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.topAppBar.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.topAppBar.title = when (destination.id) {
                R.id.folderListFragment -> {
                    getString(R.string.app_name)
                }

                else -> getString(R.string.app_name)
            }
        }
    }
}