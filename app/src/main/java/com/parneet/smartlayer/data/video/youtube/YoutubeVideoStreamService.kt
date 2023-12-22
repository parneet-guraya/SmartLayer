package com.parneet.smartlayer.data.video.youtube

import com.parneet.smartlayer.model.StreamSubtitle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.services.youtube.YoutubeService
import org.schabi.newpipe.extractor.stream.StreamInfo
import org.schabi.newpipe.extractor.stream.SubtitlesStream
import org.schabi.newpipe.extractor.stream.VideoStream

class YoutubeVideoStreamService {
    private var youtubeService: YoutubeService
    private var isStreamInfoFetched = false
    private var streamInfo: StreamInfo? = null

    init {
        NewPipe.init(SimpleDownloader.init(null))
        youtubeService = NewPipe.getService(0) as YoutubeService
    }

    private suspend fun getStreamInfo(youtubeVideoUrl: String) {
        withContext(Dispatchers.IO) {
            streamInfo = StreamInfo.getInfo(youtubeService, youtubeVideoUrl)
        }
    }

    suspend fun getVideoAudioStream(youtubeVideoUrl: String): VideoStream? {
        fetchStreamInfoIfNot(youtubeVideoUrl)
        return withContext(Dispatchers.IO) {
            val videoAudioStream = streamInfo?.videoStreams
            val video720p =
                videoAudioStream?.first { videoStream -> videoStream.getResolution() == RESOLUTION_720P }
            return@withContext video720p
        }
    }

    suspend fun getStreamTitle(youtubeVideoUrl: String):String?{
        fetchStreamInfoIfNot(youtubeVideoUrl)
        return streamInfo?.name
    }

    suspend fun getSubtitlesStream(youtubeVideoUrl: String):List<SubtitlesStream?>?{
        fetchStreamInfoIfNot(youtubeVideoUrl)
        return streamInfo?.subtitles
    }
    private suspend fun fetchStreamInfoIfNot(youtubeVideoUrl: String) {
        if (!isStreamInfoFetched) {
            getStreamInfo(youtubeVideoUrl)
            isStreamInfoFetched = true
        }
    }

    companion object {
        const val RESOLUTION_720P = "720p"
    }
}