package com.parneet.smartlayer.data.wikiarticles

import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.model.WikiArticlesListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WikiArticlesRepository(private val wikipediaApi: WikipediaApi) {

    suspend fun fetchArticles(searchQuery: String): Resource<WikiArticlesListResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = wikipediaApi.fetchArticles(searchQuery)
                Resource.Success(response)

            } catch (e: Exception) {
                Resource.Failure(e)
            }
        }
    }

    companion object {
        const val WIKI_ARTICLES_BASE_URL = "https://api.wikimedia.org/core/v1/wikipedia/en/search/"

    }
}