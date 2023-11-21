package com.parneet.smartlayer

import android.content.Context
import android.view.View
import com.google.android.material.progressindicator.BaseProgressIndicator
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec

object UiUtils {

    fun toggleLoading(
        showLoading: Boolean,
        view: View?,
        loadingView: BaseProgressIndicator<out BaseProgressIndicatorSpec>,
        shouldGoInvisible: Boolean = false
    ) {
        if (showLoading) {
            loadingView.show()
            if (view != null) {
                view.visibility = if (shouldGoInvisible) {
                    View.INVISIBLE
                } else {
                    View.GONE
                }
            }
        } else {
            if (view != null) {
                view.visibility = View.VISIBLE
            }
            loadingView.hide()
        }

    }

    fun dpToPixels(sizeInDp: Int, context: Context): Int {
        val density = context.resources.displayMetrics.density.toInt()
        return sizeInDp * density
    }
}