package com.parneet.smartlayer.data.wikiarticles

import com.parneet.smartlayer.common.Response
import com.parneet.smartlayer.model.WikiArticlesListResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WikiArticlesRepository(private val wikipediaApi: WikipediaApi) {

    suspend fun fetchArticles(searchQuery: String): Flow<Response<WikiArticlesListResponse>> =
        flow {
            emit(Response.Loading(true))
            try {
                val response = wikipediaApi.fetchArticles(searchQuery)
                emit(Response.Loading(false))
                emit(Response.Success(response))

            } catch (e: Exception) {
                emit(Response.Loading(false))
                emit(Response.Error(e))

            }
        }

    companion object {
        const val WIKI_ARTICLES_BASE_URL = "https://api.wikimedia.org/core/v1/wikipedia/en/search/"

    }
}