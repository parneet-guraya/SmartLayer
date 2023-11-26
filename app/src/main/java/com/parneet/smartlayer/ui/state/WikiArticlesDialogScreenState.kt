package com.parneet.smartlayer.ui.state

import com.parneet.smartlayer.model.Page

data class WikiArticlesDialogScreenState(
    val isLoading: Boolean = false,
    val articlesList: List<Page>? = null,
    val errorMessage: String = ""
) {
    val isListEmpty = articlesList?.isEmpty() ?: false
}