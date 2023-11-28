package com.parneet.smartlayer.ui.util

import android.Manifest
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.Toast
import com.google.android.material.progressindicator.BaseProgressIndicator
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec
import com.google.android.material.snackbar.Snackbar

object AppUtils {

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

    fun toggleVisibility(
        toggleVisibility: Boolean,
        view: View?,
        shouldGoInvisible: Boolean = false
    ) {
        if (view != null) {
            view.visibility = if (toggleVisibility) {
                View.VISIBLE
            } else {
                if (shouldGoInvisible) {
                    View.INVISIBLE
                } else {
                    View.GONE
                }
            }
        }
    }

    fun dpToPixels(sizeInDp: Int, applicationContext: Context): Int {
        val density = applicationContext.resources.displayMetrics.density.toInt()
        return sizeInDp * density
    }

    fun showSnackBar(view: View, message: String?, duration: Int = Snackbar.LENGTH_SHORT) {
        if (message != null) Snackbar.make(view, message, duration).show()
    }

    fun showToast(
        applicationContext: Context,
        message: String?,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        if (message != null) Toast.makeText(applicationContext, message, duration).show()
    }

    fun getReadMediaPermission(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_VIDEO
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }
    }
}