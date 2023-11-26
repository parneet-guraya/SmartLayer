package com.parneet.smartlayer.ui.viewmodels

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.TrackSelectionParameters
import com.parneet.smartlayer.common.Response
import com.parneet.smartlayer.ui.service.tokenizer.OpenNLPTokenizer
import com.parneet.smartlayer.ui.service.translation.MlKitTranslationService
import com.parneet.smartlayer.ui.state.SubtitleHeaderState
import com.parneet.smartlayer.ui.state.WordsChipGroupState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayerViewModel(private val application: Application) : AndroidViewModel(application) {
    var videoUri: Uri? = null
    var subtitleUri: Uri? = null
    var playWhenReady: Boolean = true
    var playBackPosition: Long = 0L
    var currentPlayingMediaItem: MediaItem? = null
    var currentSourceLang: String = "en"
    var currentTargetLang: String = "hi"
    private var openNLPTokenizer: OpenNLPTokenizer? = null
    private var _wordsChipGroupState = MutableStateFlow(WordsChipGroupState())
    val wordsChipGroupState = _wordsChipGroupState.asStateFlow()
    var trackSelectionParameters: TrackSelectionParameters? = null


    private var _translateResponseState = MutableStateFlow<Response<String>>(Response.Loading(true))
    val translateResponseState: StateFlow<Response<String>> = _translateResponseState

    private val mlKitTranslationService = MlKitTranslationService()
    private val _subtitleHeaderState = MutableStateFlow(SubtitleHeaderState())
    val subtitleHeaderState = _subtitleHeaderState.asStateFlow()


    fun initializeSubtitleHeader(text: String) {
        _subtitleHeaderState.update {
            it.copy(
                currentText = text,
                originalText = text,
                isOriginalShowing = true
            )
        }
    }

    fun updateCurrentSubText(text: String) {
        _subtitleHeaderState.update { it.copy(currentText = text) }
    }

    fun translateText(
        originalString: String,
        sourceLanguage: String,
        targetLanguage: String
    ) {
        viewModelScope.launch {
            mlKitTranslationService.translate(
                originalString,
                sourceLanguage,
                targetLanguage
            ).collectLatest {
                _translateResponseState.value = it
            }
        }
    }

    fun splitIntoWords(subtitleString: String) {
        _wordsChipGroupState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            if (openNLPTokenizer == null) {
                println("model initialised")
                openNLPTokenizer = OpenNLPTokenizer(context = application.applicationContext)
                openNLPTokenizer?.initialize()
            }
            try {
                val tokens = openNLPTokenizer?.tokenizeString(subtitleString)
                _wordsChipGroupState.update { it.copy(isLoading = false, words = tokens) }
            } catch (e: Exception) {
                _wordsChipGroupState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.message ?: "Error while tokenizing string."
                    )
                }
            }
        }
    }

    fun releaseTokenizerModel() {
        println("release model")
        openNLPTokenizer?.release()
        openNLPTokenizer = null
    }
}