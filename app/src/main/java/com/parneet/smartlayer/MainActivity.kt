package com.parneet.smartlayer

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.parneet.smartlayer.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

const val LOG_TAG = "MYCUSTOMLOGTAG"

fun logDebug(message: String) {
    Log.d(LOG_TAG, message)
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val videoPickerLauncher: ActivityResultLauncher<Intent> = onVideoResult()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)
        requestPermissionIfNeeded()
        binding.pickVideoFab.setOnClickListener {
            launchVideoPicker()
        }
    }
    private fun requestPermissionIfNeeded() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_MEDIA_VIDEO
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            lifecycleScope.launch {
                val foldersList = VideoManager.getVideoFolders(applicationContext)
                println("Folders List: $foldersList")
            }
        } else {
            requestPermissionLauncher().launch(Manifest.permission.READ_MEDIA_VIDEO)
        }
    }

    private fun requestPermissionLauncher(): ActivityResultLauncher<String> {
        return registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // show folders
                lifecycleScope.launch {
                    val foldersList = VideoManager.getVideoFolders(applicationContext)
                    println("Folders List: $foldersList")
                }
            } else {
                Toast.makeText(this@MainActivity, "Permission Denied", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun launchVideoPicker() {
        val videoPickIntent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "video/*"
        }
        videoPickerLauncher.launch(videoPickIntent)
    }

    private fun onVideoResult(): ActivityResultLauncher<Intent> {
        return registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                val intent = activityResult.data
                if (intent != null) {
                    startPlayer(intent.data!!)
                }
            }

        }
    }

    private fun startPlayer(uri: Uri) {
        val startPlayerIntent = Intent(this, PlayerActivity::class.java)
        startPlayerIntent.putExtra(EXTRA_VIDEO_URI, uri)
        startActivity(startPlayerIntent)
    }

    companion object {
        const val EXTRA_VIDEO_URI = "com.parneet.smartlayer.MainActivity.EXTRA_VIDEO_URI"
    }
}