package com.parneet.smartlayer.model

import android.graphics.Bitmap
import android.net.Uri

data class Video(
    val id: Long,
    val title: String,
    val duration: Int,
    val uri: Uri,
    val thumbnail: Bitmap?
)
