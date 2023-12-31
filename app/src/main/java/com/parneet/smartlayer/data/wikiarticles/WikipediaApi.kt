package com.parneet.smartlayer.data.wikiarticles

import com.parneet.smartlayer.model.WikiArticlesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaApi {

    @GET("page")
    suspend fun fetchArticles(@Query("q") searchQuery: String): WikiArticlesListResponse

}