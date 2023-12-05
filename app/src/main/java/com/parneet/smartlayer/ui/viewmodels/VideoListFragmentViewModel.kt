package com.parneet.smartlayer.ui.viewmodels

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.parneet.smartlayer.R
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.data.video.VideoRepository
import com.parneet.smartlayer.model.Video
import com.parneet.smartlayer.ui.adapter.VideoListAdapter
import com.parneet.smartlayer.ui.state.VideoListScreenState
import com.parneet.smartlayer.ui.util.AppUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VideoListFragmentViewModel(private val application: Application) :
    AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(VideoListScreenState())
    val uiState = _uiState.asStateFlow()
    lateinit var videoListAdapter: VideoListAdapter
    private val videoRepository = VideoRepository()


    fun loadVideos(bucketId: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val response =
                videoRepository.getVideosInFolder(application.applicationContext, bucketId)
            when (response) {
                is Resource.Error -> _uiState.update {
                    it.copy(
                        isLoading = false, errorMessage = response.exception.message!!
                    )
                }

                is Resource.Success -> _uiState.update {
                    it.copy(
                        isLoading = false, videoList = response.data
                    )
                }
            }
        }
    }

    private fun millisToTimeFormat(durationMillis: Int): String {
        val durationInSeconds: Int = (durationMillis / 1000)

        val hours = durationInSeconds / 3600;
        val minutes = (durationInSeconds % 3600) / 60;
        val seconds = durationInSeconds % 60;

        return if (hours > 0) {
            "${hours.toString().padStart(2, '0')}:${
                minutes.toString().padStart(2, '0')
            }:${seconds.toString().padStart(2, '0')}"
        } else {
            "${minutes.toString().padStart(2, '0')}:${
                seconds.toString().padStart(2, '0')
            }"
        }
    }

    private fun popupMenuItemClickListener(
        itemId: Int,
        video: Video,
        onShareMenuItemClick: (uri: Uri) -> Unit,
        onDetailsMenuItemClick: (video: Video) -> Unit
    ): Boolean {
        return when (itemId) {
            R.id.action_share -> {
                onShareMenuItemClick(video.uri)
                true
            }

            R.id.action_details -> {
                // show details
                onDetailsMenuItemClick(video)
                true
            }

            else -> false
        }
    }

    fun initializeAdapter(
        onItemClick: (uri: Uri, title: String) -> Unit,
        onShareMenuItemClick: (uri: Uri) -> Unit,
        onDetailsMenuItemClick: (video: Video) -> Unit
    ) {
        videoListAdapter = VideoListAdapter(onItemClick = { uri, title ->
            onItemClick(uri, title)
        }, loadThumbnail = { uri ->
            videoRepository.getVideoThumbnail(
                application.applicationContext, uri, 160, 90
            ) { sizeInDp ->
                AppUtils.dpToPixels(
                    sizeInDp, application.applicationContext
                )
            }
        }, millisToTimeFormat = { millis -> millisToTimeFormat(millis) },
            onPopupMenuItemClick = { menuItemId, video ->
                popupMenuItemClickListener(
                    menuItemId,
                    video,
                    onShareMenuItemClick,
                    onDetailsMenuItemClick
                )
            })
    }
}