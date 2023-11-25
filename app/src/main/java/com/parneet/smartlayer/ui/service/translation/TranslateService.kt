package com.parneet.smartlayer.ui.service.translation

import com.parneet.smartlayer.common.Response
import kotlinx.coroutines.flow.Flow

interface TranslateService {

    fun translate(
        originalString: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<Response<String>>

    companion object {
        val langMap = mapOf(
            "Hindi" to "hi",
            "Afrikaans" to "af",
            "Arabic" to "ar",
            "Belarusian" to "be",
            "Bulgarian" to "bg",
            "Bengali" to "bn",
            "Catalan" to "ca",
            "Czech" to "cs",
            "Welsh" to "cy",
            "Danish" to "da",
            "German" to "de",
            "Greek" to "el",
            "English" to "en",
            "Esperanto" to "eo",
            "Spanish" to "es",
            "Estonian" to "et",
            "Persian" to "fa",
            "Finnish" to "fi",
            "French" to "fr",
            "Irish" to "ga",
            "Galician" to "gl",
            "Gujarati" to "gu",
            "Hebrew" to "he",
            "Croatian" to "hr",
            "Haitian" to "ht",
            "Hungarian" to "hu",
            "Indonesian" to "id",
            "Icelandic" to "is",
            "Italian" to "it",
            "Japanese" to "ja",
            "Georgian" to "ka",
            "Kannada" to "kn",
            "Korean" to "ko",
            "Lithuanian" to "lt",
            "Latvian" to "lv",
            "Macedonian" to "mk",
            "Marathi" to "mr",
            "Malay" to "ms",
            "Maltese" to "mt",
            "Dutch" to "nl",
            "Norwegian" to "no",
            "Polish" to "pl",
            "Portuguese" to "pt",
            "Romanian" to "ro",
            "Russian" to "ru",
            "Slovak" to "sk",
            "Slovenian" to "sl",
            "Albanian" to "sq",
            "Swedish" to "sv",
            "Swahili" to "sw",
            "Tamil" to "ta",
            "Telugu" to "te",
            "Thai" to "th",
            "Tagalog" to "tl",
            "Turkish" to "tr",
            "Ukrainian" to "uk",
            "Urdu" to "ur",
            "Vietnamese" to "vi",
            "Chinese" to "zh"
        )
    }
}