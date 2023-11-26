package com.parneet.smartlayer.data.video

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.common.Response
import com.parneet.smartlayer.model.Folder
import com.parneet.smartlayer.model.Video
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoRepository {

    // revisit will there be any problem if context saved using val context in the constructor (for both application and context)
    suspend fun getVideoFolders(applicationContext: Context): Resource<List<Folder>> {
        return withContext(Dispatchers.IO) {
            try {
                val folderList = VideoManager.getVideoFolders(applicationContext)
                return@withContext Resource.Success(folderList)
            } catch (e: Exception) {
                return@withContext Resource.Failure(e)
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
                return@withContext Resource.Failure(e)
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
            Resource.Failure(e)
        }
    }


}