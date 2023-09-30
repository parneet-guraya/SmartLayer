package com.parneet.smartlayer.service

import androidx.lifecycle.LiveData
import com.parneet.smartlayer.model.Response

interface TranslateService {

    suspend fun identifyLanguage(string: String): LiveData<Response<String>>
     fun translate(
        string: String,
        sourceLanguage: String,
        targetLanguage: String
    ): LiveData<Response<String>>
}