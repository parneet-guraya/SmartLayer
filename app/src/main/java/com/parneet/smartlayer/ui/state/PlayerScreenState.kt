package com.parneet.smartlayer.ui.state

import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.TrackSelectionParameters
import com.parneet.smartlayer.ui.service.translation.MlKitTranslationService

data class PlayerScreenState(
    var videoUri: Uri? = null,
    var subtitleUri: Uri? = null,
    var playWhenReady: Boolean = true,
    var playBackPosition: Long = 0L,
    var currentPlayingMediaItem: MediaItem? = null,
    var trackSelectionParameters: TrackSelectionParameters? = null
)

data class SubtitleHeaderState(
    val currentText: String = "",
    val originalText: String = "",
    val isOriginalShowing: Boolean = false
)

data class WordsChipGroupState(
    val isLoading: Boolean = false,
    val words: List<String>? = null,
    val errorMessage: String = ""
)

data class TranslatorState(
    val isLoading: Boolean = false,
    val translateResult: String = "",
    val currentSourceLang: String = MlKitTranslationService.langMap["English"]!!,
    val currentTargetLang: String = MlKitTranslationService.langMap["Hindi"]!!,
    val errorMessage: String = ""
)