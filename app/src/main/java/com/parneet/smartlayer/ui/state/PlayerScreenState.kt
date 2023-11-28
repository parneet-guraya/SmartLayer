package com.parneet.smartlayer.ui.state

import com.parneet.smartlayer.ui.service.translation.MlKitTranslationService

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
    val currentSourceLang: String = MlKitTranslationService.langMap[DEFAULT_SOURCE_LANGUAGE]!!,
    val currentTargetLang: String = MlKitTranslationService.langMap[DEFAULT_TARGET_LANGUAGE]!!,
    val errorMessage: String = ""
){
    companion object{
        private const val DEFAULT_SOURCE_LANGUAGE ="English"
        private const val DEFAULT_TARGET_LANGUAGE ="Hindi"
    }
}