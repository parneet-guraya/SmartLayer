package com.parneet.smartlayer.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.data.RetrofitClient
import com.parneet.smartlayer.data.wikiarticles.WikiArticlesRepository
import com.parneet.smartlayer.data.wikiarticles.WikipediaApi
import com.parneet.smartlayer.ui.adapter.WikiArticlesListAdapter
import com.parneet.smartlayer.ui.state.WikiArticlesDialogScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WikipediaArticlesDialogViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(WikiArticlesDialogScreenState())
    val uiState = _uiState.asStateFlow()
    private val wikiArticlesRepository =
        WikiArticlesRepository(
            RetrofitClient.create(WikiArticlesRepository.WIKI_ARTICLES_BASE_URL)
                .create(WikipediaApi::class.java)
        )
    lateinit var adapter: WikiArticlesListAdapter


    fun initializeAdapter(onItemClick: (pageId: Int) -> Unit) {
        adapter = WikiArticlesListAdapter { pageId -> onItemClick(pageId) }
    }

    fun loadWikiArticles(searchQuery: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val response = wikiArticlesRepository.fetchArticles(searchQuery)
            when (response) {
                is Resource.Failure -> _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = response.exception.message ?: "Error Fetching Articles"
                    )
                }

                is Resource.Success -> _uiState.update {
                    it.copy(
                        isLoading = false,
                        articlesList = response.data.pages
                    )
                }
            }
        }
    }

}