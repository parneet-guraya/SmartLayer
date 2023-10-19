package com.parneet.smartlayer.model.service

import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import com.parneet.smartlayer.logDebug
import com.parneet.smartlayer.model.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class MlKitTranslationService : TranslateService {

//    override suspend fun identifyLanguage(string: String): LiveData<Response<String>> {
//        identifyLanguageResponseState.value = Response.Loading
//        withContext(Dispatchers.IO) {
//            try {
//                val languageIdentificationOptions =
//                    LanguageIdentificationOptions.Builder().setConfidenceThreshold(0.2f).build()
//                val identifyTask = LanguageIdentification.getClient(languageIdentificationOptions)
//                    .identifyLanguage(string)
//                val identifiedLangCode = Tasks.await(identifyTask)
//                identifyLanguageResponseState.postValue(Response.Success(identifiedLangCode))
//            } catch (exception: Exception) {
//                identifyLanguageResponseState.postValue(Response.Error(exception))
//            }
//        }
//        return identifyLanguageResponseState
//    }

    override fun translate(
        string: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<Response<String>> {
        return callbackFlow {
            val options = TranslatorOptions.Builder()
                .setSourceLanguage(sourceLanguage)
                .setTargetLanguage(targetLanguage)
                .build()
            val translator = Translation.getClient(options)
            trySend(Response.Loading)
            translator.downloadModelIfNeeded().addOnSuccessListener {
                try {
                    translator.translate(string).addOnSuccessListener {
                        trySend(Response.Success(it))
                    }
                } catch (exception: Exception) {
                    trySend(Response.Error(exception))
                }
            }.addOnFailureListener {
                logDebug(it.message.toString())
            }
            awaitClose {
                translator.close()
            }
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