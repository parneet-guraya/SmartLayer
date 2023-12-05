package com.parneet.smartlayer.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.ActivityMainBinding
import com.parneet.smartlayer.ui.fragments.FolderListFragment


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

        navController.addOnDestinationChangedListener { _, destination, arguments ->
            binding.topAppBar.title = when (destination.id) {
                R.id.folderListFragment -> {
                    getString(R.string.app_name)
                }

                R.id.videoFolderFragment -> {
                    arguments?.getString(FolderListFragment.EXTRA_BUCKET_DISPLAY_NAME)
                }

                else -> ""
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
                getString(R.string.about)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}