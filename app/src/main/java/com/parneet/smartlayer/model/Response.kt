package com.parneet.smartlayer.model

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error<Nothing>(val exception: Exception? = null,val message:String? = null) : Response<Nothing>()
    data class Loading(val isLoading: Boolean) : Response<Nothing>()
}