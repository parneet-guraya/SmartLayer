package com.parneet.smartlayer.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.topAppBar.setupWithNavController(navController)
        setSupportActionBar(binding.topAppBar)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.topAppBar.title = when (destination.id) {
                R.id.folderListFragment -> {
                    getString(R.string.app_name)
                }

                else -> getString(R.string.app_name)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about -> {
                println("about")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}