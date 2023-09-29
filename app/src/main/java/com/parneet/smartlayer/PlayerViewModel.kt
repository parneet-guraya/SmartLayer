package com.parneet.smartlayer

import android.net.Uri
import androidx.lifecycle.ViewModel

class PlayerViewModel : ViewModel() {
    var videoUri: Uri? = null
    var playWhenReady: Boolean = true
    var playBackPosition: Long = 0L

}