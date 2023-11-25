package com.parneet.smartlayer.ui.service.translation

import com.google.android.gms.tasks.Tasks
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions
import com.parneet.smartlayer.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class MlKitTranslationService : TranslateService {

    override fun translate(
        originalString: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<Response<String>> {
        return flow {
            emit(Response.Loading(true))
            try {
                val translatedString = translateText(originalString, sourceLanguage, targetLanguage)
                emit(Response.Loading(false))
                emit(Response.Success(translatedString))


            } catch (e: Exception) {
                emit(Response.Loading(false))
                emit(Response.Error(e))
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
}