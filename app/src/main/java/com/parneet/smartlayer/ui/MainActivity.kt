package com.parneet.smartlayer.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
    }
}