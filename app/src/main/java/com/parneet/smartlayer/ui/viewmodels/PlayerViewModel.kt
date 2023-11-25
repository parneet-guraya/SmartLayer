package com.parneet.smartlayer.ui.viewmodels

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.TrackSelectionParameters
import com.parneet.smartlayer.model.Response
import com.parneet.smartlayer.ui.service.translation.MlKitTranslationService
import com.parneet.smartlayer.ui.service.tokenizer.OpenNLPTokenizer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(private val application: Application) : AndroidViewModel(application) {
    var videoUri: Uri? = null
    var subtitleUri: Uri? = null
    var playWhenReady: Boolean = true
    var playBackPosition: Long = 0L
    var currentPlayingMediaItem: MediaItem? = null
    private val _currentSubText: MutableLiveData<String?> = MutableLiveData("")
    val currentSubText: LiveData<String?> = _currentSubText
    var originalSubText: String = ""
    var isOriginalSubShowing = true
    var currentSourceLang: String = "en"
    var currentTargetLang: String = "hi"
    private var openNLPTokenizer: OpenNLPTokenizer? = null
    private var _tokenizedWords = MutableLiveData<Response<Array<String>>>()
    val tokenizedWords: LiveData<Response<Array<String>>> = _tokenizedWords
    var trackSelectionParameters: TrackSelectionParameters? = null


    private var _translateResponseState = MutableStateFlow<Response<String>>(Response.Loading(true))
    val translateResponseState: StateFlow<Response<String>> = _translateResponseState

    private val mlKitTranslationService = MlKitTranslationService()

    fun updateCurrentSubText(text: String?) {
        _currentSubText.value = text
    }

    fun translateText(
        string: String,
        sourceLanguage: String,
        targetLanguage: String
    ) {
        // here we're creating a new flow in each call hence same number of times observer will be notified. But why still observer getting notified once.
        // Even though we created multiple flow (by calling this function multiple times) For example: Like if it was a call to room databse about getting
        // the list then it would emit data to every flows get created. Is it because room is itself actively throwing values so every flow is getting it and
        // here in our case we are emitting the values right away?
        viewModelScope.launch {
            mlKitTranslationService.translate(
                string,
                sourceLanguage,
                targetLanguage
            ).collect {
                _translateResponseState.value = it
            }
        }
    }

    fun splitIntoWords(subtitleString: String) {
        _tokenizedWords.value = Response.Loading(true)
        viewModelScope.launch {
            if (openNLPTokenizer == null) {
                println("model initialised")
                openNLPTokenizer = OpenNLPTokenizer(context = application.applicationContext)
                openNLPTokenizer?.initialize()
            }
            try {
                val tokens = openNLPTokenizer?.tokenizeString(subtitleString)
                _tokenizedWords.value = Response.Loading(false)
                _tokenizedWords.value = Response.Success(tokens)
            } catch (e: Exception) {
                _tokenizedWords.value = Response.Loading(true)
                _tokenizedWords.value = Response.Error(e)
            }
        }
    }

    fun releaseTokenizerModel() {
        println("release model")
        openNLPTokenizer?.release()
        openNLPTokenizer = null
    }
}