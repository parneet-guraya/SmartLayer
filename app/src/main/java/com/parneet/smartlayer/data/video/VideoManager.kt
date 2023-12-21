package com.parneet.smartlayer.data.video

import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.FileUtils
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Size
import com.parneet.smartlayer.R
import com.parneet.smartlayer.model.Folder
import com.parneet.smartlayer.model.Resolution
import com.parneet.smartlayer.model.Video
import com.parneet.smartlayer.model.VideoMetaData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

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
        bucketId: String
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


                while (cur.moveToNext()) {
                    val id = cur.getLong(idColumn)
                    val uri =
                        ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id)
                    videoList.add(
                        Video(
                            id = id,
                            title = cur.getString(titleColumn),
                            duration = cur.getInt(durationColumn),
                            uri = uri
                        )
                    )
                }
            }
            return@withContext videoList
        }
    }

    suspend fun getSubtitleName(subtitleUri: Uri?, applicationContext: Context): String {
        var displayName: String = applicationContext.getString(R.string.default_string)
        return if (subtitleUri != null) {
            withContext(Dispatchers.IO) {
                val cursor = applicationContext.contentResolver.query(
                    subtitleUri,
                    null,
                    null,
                    null,
                    null,
                    null
                )

                cursor.use { cur ->
                    if (cur != null) {
                        if (cur.moveToFirst()) {
                            val displayNameColumnIndex =
                                cur.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME)
                            if (displayNameColumnIndex >= 0) {
                                displayName =
                                    cur.getString(displayNameColumnIndex)
                            }

                        }
                    }
                }
                return@withContext displayName
            }
        } else {
            displayName
        }
    }

    suspend fun fetchMetaData(
        applicationContext: Context,
        video: Video
    ): VideoMetaData {
        return withContext(Dispatchers.IO) {

            MediaMetadataRetriever().use { metadataRetriever ->
                val uri = video.uri
                val path = getFilePath(applicationContext, uri)
                metadataRetriever.setDataSource(applicationContext, uri)

                val title = video.title
                val duration = video.duration
                val size = path?.let { File(it).length() } ?: 0
                val width =
                    metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH)
                val height =
                    metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT)
                val resolution = Resolution(width, height)

                return@withContext VideoMetaData(title, duration, size, resolution)
            }
        }
    }

    suspend fun fetchVideoTitle(applicationContext: Context, uri: Uri): String? {
        return withContext(Dispatchers.IO) {
            val cursor = applicationContext.contentResolver.query(uri, null, null, null, null, null)
            File("'").nameWithoutExtension
            cursor.use { cur ->
                if (cur != null) {
                    val displayNameIndex =
                        cur.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)
                    if (cur.moveToFirst()) {
                        val title = cur.getString(displayNameIndex)

                        return@withContext title
                    }
                }
                return@withContext null
            }
        }
    }

    private fun getFilePath(applicationContext: Context, uri: Uri): String? {
        val cursor = applicationContext.contentResolver.query(
            uri,
            null,
            null,
            null,
            null,
            null
        )
        var filePath: String? = null
        cursor.use { cur ->
            if (cur != null) {
                val filePathIndex = cur.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)
                if (cur.moveToFirst()) {
                    filePath = cur.getString(filePathIndex)
                }
            }
        }
        return filePath
    }

    fun loadThumbnail(
        applicationContext: Context,
        uri: Uri,
        widthInDp: Int,
        heightInDp: Int,
        sizeInPixels: (Int) -> Int
    ): Bitmap? {
        return applicationContext.contentResolver.loadThumbnail(
            uri,
            Size(
                sizeInPixels(widthInDp),
                sizeInPixels(heightInDp)
            ),
            null
        )
    }

    fun loadThumbnail(
        applicationContext: Context,
        uri: Uri,
        widthInPixels: Int,
        heightInPixels: Int,
    ): Bitmap? {
        return applicationContext.contentResolver.loadThumbnail(
            uri,
            Size(
                widthInPixels,
                heightInPixels
            ),
            null
        )
    }
}