package com.parneet.smartlayer.common

sealed class Resource<T>() {
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val exception: Exception) : Resource<T>()
}