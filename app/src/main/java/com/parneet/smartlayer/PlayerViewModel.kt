package com.parneet.smartlayer

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import com.parneet.smartlayer.model.Response
import com.parneet.smartlayer.service.MlKitTranslationService

class PlayerViewModel : ViewModel() {
    var videoUri: Uri? = null
    var playWhenReady: Boolean = true
    var playBackPosition: Long = 0L
    var currentPlayingMediaItem: MediaItem? = null
    private val _currentSubText: MutableLiveData<String?> = MutableLiveData("")
    val currentSubText: LiveData<String?> = _currentSubText
    var originalSubText: String = ""
    var isOriginalSubShowing = true
    var currentSourceLang: String = "en"
    var currentTargetLang: String = "hi"

    private var _translateResponseState = MutableLiveData<Response<String>>()
    val translateResponseState: LiveData<Response<String>> get() = _translateResponseState

    private val mlKitTranslationService = MlKitTranslationService()

    fun updateCurrentSubText(text: String?) {
        _currentSubText.value = text
    }

    fun translateText(
        string: String,
        sourceLanguage: String,
        targetLanguage: String
    ) {
        _translateResponseState =
            mlKitTranslationService.translate(
                string,
                sourceLanguage,
                targetLanguage
            ) as MutableLiveData<Response<String>>

    }

}