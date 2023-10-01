package com.parneet.smartlayer.service

import androidx.lifecycle.LiveData
import com.google.ai.generativelanguage.v1beta3.TextCompletion
import com.parneet.smartlayer.model.Response

interface GenerativeAIService {
    suspend fun generateText(prompt: String,promptStyleOption: PromptStyleOption,currentLang: String):LiveData<Response<TextCompletion>>
}