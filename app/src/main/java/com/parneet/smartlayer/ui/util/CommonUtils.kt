package com.parneet.smartlayer.ui.util

object CommonUtils {
    fun millisToTimeFormat(durationMillis: Int): String {
        val durationInSeconds: Int = (durationMillis / 1000)

        val hours = durationInSeconds / 3600;
        val minutes = (durationInSeconds % 3600) / 60;
        val seconds = durationInSeconds % 60;

        return if (hours > 0) {
            "${hours.toString().padStart(2, '0')}:${
                minutes.toString().padStart(2, '0')
            }:${seconds.toString().padStart(2, '0')}"
        } else {
            "${minutes.toString().padStart(2, '0')}:${
                seconds.toString().padStart(2, '0')
            }"
        }
    }

}