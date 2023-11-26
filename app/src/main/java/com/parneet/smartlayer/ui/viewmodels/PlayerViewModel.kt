package com.parneet.smartlayer.ui.viewmodels

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.TrackSelectionParameters
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.ui.service.tokenizer.OpenNLPTokenizer
import com.parneet.smartlayer.ui.service.translation.MlKitTranslationService
import com.parneet.smartlayer.ui.state.SubtitleHeaderState
import com.parneet.smartlayer.ui.state.TranslatorState
import com.parneet.smartlayer.ui.state.WordsChipGroupState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayerViewModel(private val application: Application) : AndroidViewModel(application) {
    var videoUri: Uri? = null
    var subtitleUri: Uri? = null
    var playWhenReady: Boolean = true
    var playBackPosition: Long = 0L
    var currentPlayingMediaItem: MediaItem? = null
    var trackSelectionParameters: TrackSelectionParameters? = null

    private var openNLPTokenizer: OpenNLPTokenizer? = null
    private val mlKitTranslationService = MlKitTranslationService()

    private var _wordsChipGroupState = MutableStateFlow(WordsChipGroupState())
    val wordsChipGroupState = _wordsChipGroupState.asStateFlow()

    private var _translatorState = MutableStateFlow(TranslatorState())
    val translatorState = _translatorState.asStateFlow()

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
        _translatorState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val translateResult = mlKitTranslationService.translate(
                originalString,
                sourceLanguage,
                targetLanguage
            )
            when (translateResult) {
                is Resource.Error -> _translatorState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = translateResult.exception.message
                            ?: "Error while translating"
                    )
                }

                is Resource.Success -> _translatorState.update {
                    it.copy(
                        isLoading = false,
                        translateResult = translateResult.data
                    )
                }
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

    fun changeTargetLanguage(targetLanguage: String) {
        _translatorState.update { it.copy(currentTargetLang = targetLanguage) }
    }

    fun changeOriginalSubShowingState(isShowing: Boolean) {
        _subtitleHeaderState.update { it.copy(isOriginalShowing = isShowing) }
    }

    fun releaseTokenizerModel() {
        println("release model")
        openNLPTokenizer?.release()
        openNLPTokenizer = null
    }
}