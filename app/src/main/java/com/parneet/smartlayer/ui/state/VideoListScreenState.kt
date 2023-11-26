package com.parneet.smartlayer.ui.state

import com.parneet.smartlayer.model.Video

data class VideoListScreenState(
    val isLoading: Boolean = false,
    val videoList: List<Video>? = null,
    val errorMessage: String = ""
) {
    val isListEmpty: Boolean = videoList?.isEmpty() ?: false
}