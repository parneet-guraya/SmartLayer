package com.parneet.smartlayer.ui.util

import android.text.format.DateUtils

object CommonUtils {
    fun millisToTimeFormat(durationMillis: Int): String {
        val durationSeconds = durationMillis / 1000L
        return DateUtils.formatElapsedTime(durationSeconds)
    }
}