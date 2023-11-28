package com.parneet.smartlayer.ui.viewmodels

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.TrackSelectionParameters
import androidx.media3.exoplayer.ExoPlayer
import com.parneet.smartlayer.R
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
    var player: ExoPlayer? = null
        private set
    private var playWhenReady: Boolean = true
    private var playBackPosition: Long = 0L
    private var currentPlayingMediaItem: MediaItem? = null
    private var trackSelectionParameters: TrackSelectionParameters? = null
    var currentText: String? = ""

    private var _subtitlesUriListState = MutableStateFlow(listOf<Uri?>())
    val subtitlesUriListState = _subtitlesUriListState.asStateFlow()

    private var openNLPTokenizer: OpenNLPTokenizer? = null
    private val mlKitTranslationService = MlKitTranslationService()

    private var _wordsChipGroupState = MutableStateFlow(WordsChipGroupState())
    val wordsChipGroupState = _wordsChipGroupState.asStateFlow()

    private var _translatorState = MutableStateFlow(TranslatorState())
    val translatorState = _translatorState.asStateFlow()

    private val _subtitleHeaderState = MutableStateFlow(SubtitleHeaderState())
    val subtitleHeaderState = _subtitleHeaderState.asStateFlow()


    fun setCurrentMedia(videoUri: Uri?) {
        if (videoUri != null) {
            currentPlayingMediaItem = MediaItem.fromUri(videoUri)
        }
    }

    private fun updateCurrentMediaItem(mediaItem: MediaItem?) {
        if (mediaItem != null) {
            currentPlayingMediaItem = mediaItem
        }
    }

    fun addSubtitle(subtitleUri: Uri?) {
        _subtitlesUriListState.update { list ->
            val newList = list.toMutableList()
            newList.add(subtitleUri)
            newList.toList()
        }
    }

    fun initializeMediaPlayer() {
        player = ExoPlayer.Builder(application.applicationContext)
            .build().also { exoPlayer ->
                if (trackSelectionParameters != null) {
                    exoPlayer.trackSelectionParameters = trackSelectionParameters!!
                }
                if (subtitlesUriListState.value.isNotEmpty()) {
                    setMediaItemWithSubtitleTrack(subtitlesUriListState.value)
                } else {
                    exoPlayer.setMediaItem(currentPlayingMediaItem!!)
                }

                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(playBackPosition)
                exoPlayer.prepare()

            }
    }

    fun releasePlayer() {
        player?.let { exoPlayer ->
            playWhenReady = exoPlayer.playWhenReady
            playBackPosition = exoPlayer.currentPosition
            updateCurrentMediaItem(exoPlayer.currentMediaItem)
            trackSelectionParameters = exoPlayer.trackSelectionParameters
            exoPlayer.release()
        }
        player = null
    }

    fun setMediaItemWithSubtitleTrack(subUriList: List<Uri?>) {
        if (subUriList.isNotEmpty()) {
            val currentMediaItem = currentPlayingMediaItem
            val currentPosition = playBackPosition
            val subtitleConfigurationList = mutableListOf<MediaItem.SubtitleConfiguration>()
            subUriList.onEach { subUri ->
                if (subUri != null) {
                    val subtitleConfiguration = MediaItem.SubtitleConfiguration.Builder(subUri)
                        .setMimeType(MimeTypes.APPLICATION_SUBRIP).setLabel(application.applicationContext.getString(R.string.default_string)).build()
                    subtitleConfigurationList.add(subtitleConfiguration)
                }
            }
            val updatedMediaItem =
                currentMediaItem?.buildUpon()
                    ?.setSubtitleConfigurations(subtitleConfigurationList)
                    ?.build()

            if (updatedMediaItem != null) {
                println("player set updated media item")
                player?.setMediaItem(updatedMediaItem, currentPosition)
            }
        }
    }

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
                            ?: application.applicationContext.getString(R.string.error_while_translating)
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
                        errorMessage = e.message ?: application.applicationContext.getString(R.string.error_while_tokenizing)
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