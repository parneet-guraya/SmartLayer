package com.parneet.smartlayer.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.data.video.VideoRepository
import com.parneet.smartlayer.ui.adapter.FolderListAdapter
import com.parneet.smartlayer.ui.state.FolderListScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FolderListFragmentViewModel(private val application: Application) :
    AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(FolderListScreenState())
    val uiState = _uiState.asStateFlow()
    lateinit var adapter: FolderListAdapter
    private val videoRepository = VideoRepository()


    fun initializeListAdapter(onItemClick: (bucketId: String) -> Unit) {
        adapter = FolderListAdapter { bucketId ->
            onItemClick(bucketId)
        }
    }

    fun loadVideoFolders() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val response = videoRepository.getVideoFolders(application.applicationContext)
            when (response) {
                is Resource.Failure -> _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = response.exception.message!!
                    )
                }

                is Resource.Success -> _uiState.update {
                    it.copy(
                        isLoading = false,
                        folderList = response.data
                    )
                }
            }
        }
    }

}