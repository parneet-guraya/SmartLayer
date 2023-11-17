package com.parneet.smartlayer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.parneet.smartlayer.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

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
        requestPermissionIfNeeded()

    }

    private fun requestPermissionIfNeeded() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_MEDIA_VIDEO
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            loadVideoFolders()
        } else {
            requestPermissionLauncher().launch(Manifest.permission.READ_MEDIA_VIDEO)
        }
    }

    private fun requestPermissionLauncher(): ActivityResultLauncher<String> {
        return registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // show folders
                loadVideoFolders()
            } else {
                Toast.makeText(this@MainActivity, "Permission Denied", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun startPlayer(uri: Uri) {
        val startPlayerIntent = Intent(this, PlayerActivity::class.java)
        startPlayerIntent.putExtra(EXTRA_VIDEO_URI, uri)
        startActivity(startPlayerIntent)
    }

    private fun loadVideoFolders() {
        lifecycleScope.launch {
            val videoFolderList = VideoManager.getVideoFolders(applicationContext)
            val adapter = FolderListAdapter(videoFolderList)
            binding.foldersRecyclerView.layoutManager = GridLayoutManager(this@MainActivity,3)
            binding.foldersRecyclerView.adapter = adapter
        }
    }

    companion object {
        const val EXTRA_VIDEO_URI = "com.parneet.smartlayer.MainActivity.EXTRA_VIDEO_URI"
    }
}