package com.parneet.smartlayer

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parneet.smartlayer.model.Response
import com.parneet.smartlayer.service.MlKitTranslationService
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {
    var videoUri: Uri? = null
    var playWhenReady: Boolean = true
    var playBackPosition: Long = 0L
    private val _currentSubText: MutableLiveData<String?> = MutableLiveData("")
    val currentSubText: LiveData<String?> = _currentSubText
    var originalSubText: String = ""
    var isOriginalSubShowing = true
    var currentSourceLang:String = "en"
    var currentTargetLang:String = "hi"
    private val _identifyLangLiveData = MutableLiveData<Response<String>>()
    val identifyLangLiveData: LiveData<Response<String>> get() = _identifyLangLiveData
    private var _translateResponseState = MutableLiveData<Response<String>>()
    val translateResponseState: LiveData<Response<String>> get() = _translateResponseState

    private val mlKitTranslationService = MlKitTranslationService()


    fun updateCurrentSubText(text: String?) {
        _currentSubText.value = text
    }

    fun identifyLanguage(string: String) {
        viewModelScope.launch {
            _identifyLangLiveData.value = mlKitTranslationService.identifyLanguage(string).value
        }
    }

    fun translateText(
        string: String,
        sourceLanguage: String,
        targetLanguage: String
    ) {
            _translateResponseState =
                mlKitTranslationService.translate(string, sourceLanguage, targetLanguage) as MutableLiveData<Response<String>>

    }

}