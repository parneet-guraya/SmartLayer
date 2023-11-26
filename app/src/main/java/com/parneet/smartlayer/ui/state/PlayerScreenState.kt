package com.parneet.smartlayer.ui.state

//data class PlayerScreenState()
data class SubtitleHeaderState(
    val currentText: String = "",
    val originalText: String = "",
    var isOriginalShowing: Boolean = false
)

data class WordsChipGroupState(
    val isLoading: Boolean = false,
    val words: List<String>? = null,
    val errorMessage: String = ""
)

data class TranslatorState(
    val isLoading: Boolean = false,
    val translateResult: String = "",
    val errorMessage: String = ""
)