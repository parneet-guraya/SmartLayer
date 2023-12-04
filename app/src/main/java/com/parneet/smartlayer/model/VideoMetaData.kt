package com.parneet.smartlayer.model

data class VideoMetaData(
    val title: String,
    val duration: Int,
    val fileSize: Long,
    val resolution: Resolution
)

data class Resolution(val width: String?, val height: String?)
