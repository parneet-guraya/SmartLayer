package com.parneet.smartlayer.ui.service.translation

import com.parneet.smartlayer.common.Resource

interface TranslateService {

    suspend fun translate(
        originalString: String,
        sourceLanguage: String,
        targetLanguage: String
    ): Resource<String>
}