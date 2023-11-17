package com.parneet.smartlayer

import android.content.ContentUris
import android.content.Context
import android.provider.MediaStore
import android.util.Size
import com.parneet.smartlayer.model.Folder
import com.parneet.smartlayer.model.Video
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object VideoManager {

    suspend fun getVideoFolders(applicationContext: Context): List<Folder> {
        return withContext(Dispatchers.IO) {
            val folderList = mutableSetOf<Folder>()
            val projection =
                arrayOf(
                    MediaStore.Video.Media.BUCKET_ID,
                    MediaStore.Video.Media.BUCKET_DISPLAY_NAME
                )
            val cursor = applicationContext.contentResolver.query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                projection,
                null,
                null,
                "${MediaStore.Video.Media.TITLE} ASC"
            )

            cursor?.use { cur ->
                val bucketIdColumn = cur.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_ID)
                val bucketDisplayNameColumn =
                    cur.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME)

                while (cur.moveToNext()) {
                    folderList.add(
                        Folder(
                            cur.getString(bucketIdColumn),
                            cur.getString(bucketDisplayNameColumn)
                        )
                    )
                }

            }
            return@withContext folderList.toList()
        }

    }

    suspend fun getVideosInFolder(
        applicationContext: Context,
        bucketId: String,
        dpToPixels: (widthInDp: Int, heightInDp: Int) -> Size
    ): List<Video> {
        return withContext(Dispatchers.IO) {
            val videoList = mutableListOf<Video>()
            val projection = arrayOf(
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.DURATION,
            )

            val selection = "${MediaStore.Video.Media.BUCKET_ID} = ?"
            val selectionArgs = arrayOf(bucketId)

            val sortOrder = "${MediaStore.Video.Media.TITLE} ASC"

            val cursor = applicationContext.contentResolver.query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                selectionArgs,
                sortOrder
            )

            cursor?.use { cur ->
                val idColumn = cur.getColumnIndexOrThrow(MediaStore.Video.Media._ID)
                val titleColumn = cur.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE)
                val durationColumn = cur.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)

                val id = cur.getLong(idColumn)
                val uri =
                    ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id)
                while (cur.moveToNext()) {
                    videoList.add(
                        Video(
                            id = id,
                            title = cur.getString(titleColumn),
                            duration = cur.getInt(durationColumn),
                            uri = uri,
                            applicationContext.contentResolver.loadThumbnail(
                                uri,
                                dpToPixels(160, 90),
                                null
                            )
                        )
                    )
                }
            }
            return@withContext videoList
        }
    }

}