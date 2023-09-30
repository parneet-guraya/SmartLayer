package com.parneet.smartlayer.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.ai.generativelanguage.v1beta3.GenerateTextRequest
import com.google.ai.generativelanguage.v1beta3.TextCompletion
import com.google.ai.generativelanguage.v1beta3.TextPrompt
import com.google.ai.generativelanguage.v1beta3.TextServiceClient
import com.google.ai.generativelanguage.v1beta3.TextServiceSettings
import com.google.api.gax.core.FixedCredentialsProvider
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider
import com.google.api.gax.rpc.FixedHeaderProvider
import com.parneet.smartlayer.BuildConfig
import com.parneet.smartlayer.logDebug
import com.parneet.smartlayer.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class GooglePalm2Service : GenerativeAIService {
    private val client = getTextServiceClient(BuildConfig.PALM_API_KEY)
    private val _generatedTextResponse = MutableLiveData<Response<TextCompletion>>()


    override suspend fun generateText(prompt: String): LiveData<Response<TextCompletion>> {
        logDebug("generateTExt")
        val textPrompt = createPrompt(prompt)
        val request = createTextRequest(textPrompt)
        _generatedTextResponse.setValue(Response.Loading)
        withContext(Dispatchers.IO) {
            logDebug("generateTExt backgroundthread")
            try {
                logDebug("generateTExt backgroundthread try block")
                val response = client.generateText(request)
                val returnedText = response.candidatesList.last()
                logDebug("generateTExt backgroundthread try block successs")
                _generatedTextResponse.postValue(Response.Success(returnedText))
            } catch (exception: Exception) {
                logDebug("generateTExt backgroundthread try block exception ${exception.message}")
                _generatedTextResponse.postValue(Response.Error(exception))
            }
        }
        return _generatedTextResponse
    }

    private fun getTextServiceClient(apiKey: String): TextServiceClient {

        val transportChannelProvider = InstantiatingGrpcChannelProvider.newBuilder()
            .setHeaderProvider(
                FixedHeaderProvider.create(
                    hashMapOf(
                        Pair(
                            "x-goog-api-key",
                            apiKey
                        )
                    )
                )
            ).build()

        val settings = TextServiceSettings.newBuilder()
            .setTransportChannelProvider(transportChannelProvider)
            .setCredentialsProvider(FixedCredentialsProvider.create(null))
            .build()

        val textServiceClient = TextServiceClient.create(settings)
        return textServiceClient
    }

    private fun createPrompt(promptText: String): TextPrompt {
        val textPrompt = TextPrompt.newBuilder()
            .setText(promptText)
            .build()
        return textPrompt
    }

    private fun createTextRequest(prompt: TextPrompt): GenerateTextRequest {
        return GenerateTextRequest.newBuilder()
            .setModel("models/text-bison-001")
            .setPrompt(prompt)
            .setCandidateCount(1)
            .build()
    }

}