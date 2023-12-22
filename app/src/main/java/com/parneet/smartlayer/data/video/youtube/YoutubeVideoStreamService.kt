package com.parneet.smartlayer.data.video.youtube

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.services.youtube.YoutubeService
import org.schabi.newpipe.extractor.stream.StreamInfo

class YoutubeVideoStreamService {
    private lateinit var youtubeService: YoutubeService

    init {
        NewPipe.init(SimpleDownloader.init(null))
        youtubeService = NewPipe.getService(0) as YoutubeService
    }

    suspend fun getVideoStream(youtubeVideoUrl: String): StreamInfo? {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext StreamInfo.getInfo(youtubeService, youtubeVideoUrl)
            } catch (exception: Exception) {
                println(exception.printStackTrace())
                return@withContext null
            }
        }
    }

    companion object {
        const val RESOLUTION_720P = "720p"
    }
}