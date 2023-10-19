package com.parneet.smartlayer.model.service

import androidx.lifecycle.LiveData
import com.parneet.smartlayer.model.Response
import kotlinx.coroutines.flow.Flow

interface TranslateService {

//    suspend fun identifyLanguage(string: String): LiveData<Response<String>>
     fun translate(
        string: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Flow<Response<String>>
}