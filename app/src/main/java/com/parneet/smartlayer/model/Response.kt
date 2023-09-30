package com.parneet.smartlayer.model

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error<Nothing>(val exception: Exception) : Response<Nothing>()
    object Loading : Response<Nothing>()
}