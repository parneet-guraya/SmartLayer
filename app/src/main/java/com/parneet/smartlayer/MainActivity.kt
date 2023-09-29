package com.parneet.smartlayer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.parneet.smartlayer.databinding.ActivityMainBinding

const val LOG_TAG = "MYCUSTOMLOGTAG"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val videoPickerLauncher: ActivityResultLauncher<Intent> = onVideoResult()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pickVideo.setOnClickListener {
            launchVideoPicker()
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