package com.parneet.smartlayer.model

import android.net.Uri

data class Video(
    val id: Long,
    val title: String,
    val duration: Int,
    val uri: Uri
)
data class Subtitle(val uri: Uri?, val title: String?)
