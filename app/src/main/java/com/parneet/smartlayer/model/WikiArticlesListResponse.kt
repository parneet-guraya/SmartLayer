package com.parneet.smartlayer.model

data class WikiArticlesListResponse(val pages: List<Page>)

data class Page(
    val id: Int,
    val key: String,
    val title: String,
    val excerpt: String,
    val matched_title: String?,
    val description: String?,
    val thumbnail: Thumbnail?
)

data class Thumbnail(
    val mimetype: String?,
    val width: Int?,
    val height: Int?,
    val duration: Int?,
){
    val url: String = ""
        get() = "https:$field"
}
