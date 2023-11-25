package com.parneet.smartlayer.data

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.parneet.smartlayer.VideoManager
import com.parneet.smartlayer.model.Folder
import com.parneet.smartlayer.model.Resource
import com.parneet.smartlayer.model.Response
import com.parneet.smartlayer.model.Video
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VideoRepository() {

    // revisit will there be any problem if context saved using val context in the constructor (for both application and context)
    suspend fun getVideoFolders(applicationContext: Context): List<Folder> {
        return VideoManager.getVideoFolders(applicationContext)
    }

    suspend fun getVideosInFolder(
        applicationContext: Context,
        bucketId: String?
    ): Flow<Response<List<Video>?>> = flow {
        emit(Response.Loading(true))
        try {
            val videoList = VideoManager.getVideosInFolder(applicationContext, bucketId)
            emit(Response.Loading(false))
            emit(Response.Success(videoList))
        } catch (e: Exception) {
            emit(Response.Loading(false))
            emit(Response.Error(e))
        }
    }

    fun getVideoThumbnail(
        applicationContext: Context,
        uri: Uri,
        sizeInPixels: (Int) -> Int
    ): Resource<Bitmap?> {
        return try {
            Resource.Success(VideoManager.loadThumbnail(applicationContext, uri, sizeInPixels))
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }


}