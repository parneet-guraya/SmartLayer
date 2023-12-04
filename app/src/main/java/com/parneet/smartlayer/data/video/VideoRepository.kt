package com.parneet.smartlayer.data.video

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.model.Folder
import com.parneet.smartlayer.model.Video
import com.parneet.smartlayer.model.VideoMetaData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoRepository {

    suspend fun getVideoFolders(applicationContext: Context): Resource<List<Folder>> {
        return withContext(Dispatchers.IO) {
            try {
                val folderList = VideoManager.getVideoFolders(applicationContext)
                return@withContext Resource.Success(folderList)
            } catch (e: Exception) {
                return@withContext Resource.Error(e)
            }
        }
    }

    suspend fun getVideosInFolder(
        applicationContext: Context,
        bucketId: String
    ): Resource<List<Video>> {
        return withContext(Dispatchers.IO) {
            try {
                val videoList = VideoManager.getVideosInFolder(applicationContext, bucketId)
                return@withContext Resource.Success(videoList)
            } catch (e: Exception) {
                return@withContext Resource.Error(e)
            }
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
            Resource.Error(e)
        }
    }

    suspend fun getSubtitleName(
        applicationContext: Context,
        subtitleUri: Uri?,
        defaultTitle: String
    ): Resource<String> {
        return try {
            val title = VideoManager.getSubtitleName(subtitleUri, applicationContext)
            Resource.Success(title)
        } catch (e: Exception) {
            Resource.Error(e, defaultTitle)
        }
    }

    suspend fun getVideoMetaData(
        applicationContext: Context,
        video: Video
    ): Resource<VideoMetaData> {
        return try {
            val videoMetaData = VideoManager.fetchMetaData(applicationContext, video)
            Resource.Success(videoMetaData)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

}