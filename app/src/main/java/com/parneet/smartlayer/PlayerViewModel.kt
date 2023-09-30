package com.parneet.smartlayer

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel : ViewModel() {
    var videoUri: Uri? = null
    var playWhenReady: Boolean = true
    var playBackPosition: Long = 0L
    private val _currentSubText: MutableLiveData<String?> = MutableLiveData("")
    val currentSubText: LiveData<String?> = _currentSubText
    var originalSubText: String = ""
    var isOriginalSubShowing = true

    fun updateCurrentSubText(text: String?) {
        _currentSubText.value = text
    }


}