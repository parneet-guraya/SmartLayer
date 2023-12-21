package com.parneet.smartlayer.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val id: Long,
    val title: String,
    val duration: Int,
    val uri: Uri
) : Parcelable

data class Subtitle(val uri: Uri?, val title: String?)
