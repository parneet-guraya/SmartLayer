package com.parneet.smartlayer.data.video.youtube

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.services.youtube.YoutubeService
import org.schabi.newpipe.extractor.stream.StreamInfo
import org.schabi.newpipe.extractor.stream.VideoStream

class YoutubeVideoStreamService {
    private lateinit var youtubeService: YoutubeService

    init {
        NewPipe.init(SimpleDownloader.init(null))
        youtubeService = NewPipe.getService(0) as YoutubeService
    }

    suspend fun getVideoStream(youtubeVideoUrl: String): VideoStream? {
        return withContext(Dispatchers.IO) {
            try {
                val streamInfo = StreamInfo.getInfo(youtubeService, youtubeVideoUrl)
                val video720p =
                    streamInfo.videoStreams.first { videoStream -> videoStream.getResolution() == RESOLUTION_720P }
                return@withContext video720p
            } catch (exception: Exception) {
                println(exception.printStackTrace())
                return@withContext null
            }
        }
    }

    companion object {
        private const val RESOLUTION_720P = "720p"
    }
}