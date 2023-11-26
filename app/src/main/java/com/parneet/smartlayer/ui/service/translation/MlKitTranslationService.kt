package com.parneet.smartlayer.ui.service.translation

import com.google.android.gms.tasks.Tasks
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions
import com.parneet.smartlayer.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MlKitTranslationService : TranslateService {

    override suspend fun translate(
        originalString: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Resource<String> {
        return withContext(Dispatchers.IO) {
            try {
                val translatedString = translateText(originalString, sourceLanguage, targetLanguage)
                return@withContext Resource.Success(translatedString)
            } catch (e: Exception) {
                return@withContext Resource.Error(e)
            }
        }
    }

    private fun buildTranslator(sourceLanguage: String, targetLanguage: String): Translator {
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(sourceLanguage)
            .setTargetLanguage(targetLanguage)
            .build()
        return Translation.getClient(options)
    }

    private suspend fun translateText(
        originalString: String,
        sourceLanguage: String,
        targetLanguage: String
    ): String {
        return withContext(Dispatchers.IO) {
            val translator = buildTranslator(sourceLanguage, targetLanguage)
            Tasks.await(translator.downloadModelIfNeeded())
            return@withContext Tasks.await(translator.translate(originalString))
        }
    }

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