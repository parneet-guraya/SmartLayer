package com.parneet.smartlayer.ui.viewmodels

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaItem.SubtitleConfiguration
import androidx.media3.common.MimeTypes
import androidx.media3.common.TrackSelectionParameters
import androidx.media3.exoplayer.ExoPlayer
import com.parneet.smartlayer.R
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.data.video.VideoRepository
import com.parneet.smartlayer.model.StreamSubtitle
import com.parneet.smartlayer.model.Subtitle
import com.parneet.smartlayer.model.YoutubeStream
import com.parneet.smartlayer.ui.service.tokenizer.OpenNLPTokenizer
import com.parneet.smartlayer.ui.service.translation.MlKitTranslationService
import com.parneet.smartlayer.ui.state.SubtitleHeaderState
import com.parneet.smartlayer.ui.state.TranslatorState
import com.parneet.smartlayer.ui.state.WordsChipGroupState
import com.parneet.smartlayer.ui.util.UIUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayerViewModel(private val application: Application) : AndroidViewModel(application) {
    var player: ExoPlayer? = null
        private set
    private var playWhenReady: Boolean = true
    private var playBackPosition: Long = 0L
    private var currentPlayingMediaItem: MediaItem? = null
    private var trackSelectionParameters: TrackSelectionParameters? = null
    var currentText: String? = ""

    private val videoRepository = VideoRepository()
    private var mediaSource: Uri? = null

    private var _subtitlesUriListState = MutableStateFlow(listOf<Subtitle>())
    val subtitlesUriListState = _subtitlesUriListState.asStateFlow()

    private var openNLPTokenizer: OpenNLPTokenizer? = null
    private val mlKitTranslationService = MlKitTranslationService()

    private var _wordsChipGroupState = MutableStateFlow(WordsChipGroupState())
    val wordsChipGroupState = _wordsChipGroupState.asStateFlow()

    private var _translatorState = MutableStateFlow(TranslatorState())
    val translatorState = _translatorState.asStateFlow()

    private val _subtitleHeaderState = MutableStateFlow(SubtitleHeaderState())
    val subtitleHeaderState = _subtitleHeaderState.asStateFlow()

    private val _videoTitleLiveData = MutableLiveData<String?>()
    val videoTitleLiveData: LiveData<String?> = _videoTitleLiveData

    private var youtubeStream: YoutubeStream? = null
    var mediaUriType: VideoUriType = VideoUriType.LOCAL
    var chosenQualityListItemIndex: Int = 0

    fun setMediaSource(videoUri: Uri?) {
        mediaSource = videoUri
    }

    private fun updateCurrentMediaItem(mediaItem: MediaItem?) {
        if (mediaItem != null) {
            currentPlayingMediaItem = mediaItem
        }
    }

    fun setVideoTitle(title: String?) {
        _videoTitleLiveData.value = title
    }

    fun getVideoTitle(uri: Uri) {
        viewModelScope.launch {
            val fetchResult = videoRepository.getVideoTitle(application.applicationContext, uri)
            when (fetchResult) {
                is Resource.Error -> {
                    fetchResult.exception.printStackTrace()
                    UIUtils.showToast(application.applicationContext, fetchResult.exception.message)
                }

                is Resource.Success -> setVideoTitle(fetchResult.data)
            }
        }
    }

    fun addSubtitle(subtitleUri: Uri?) {
        viewModelScope.launch {
            _subtitlesUriListState.update { subtitleList ->
                val title = getSubtitleDisplayName(subtitleUri)
                val subtitle = Subtitle(subtitleUri, title)
                val newList = subtitleList.toMutableList()
                newList.add(subtitle)
                newList.toList()
            }
        }
    }

    private suspend fun getSubtitleDisplayName(subtitleUri: Uri?): String? {
        val defaultTitle = application.applicationContext.getString(R.string.default_string)
        val titleResponse =
            videoRepository.getSubtitleName(
                application.applicationContext,
                subtitleUri,
                defaultTitle
            )
        return when (titleResponse) {
            is Resource.Error -> {
                UIUtils.showToast(
                    application.applicationContext!!,
                    titleResponse.exception.message
                )
                titleResponse.data
            }

            is Resource.Success -> titleResponse.data
        }
    }

    suspend fun initializeMediaPlayer() {
        val uri: Uri? = mediaSource
        if (currentPlayingMediaItem == null) {
            getMediaItemFromSource(uri, mediaUriType)
        }

        player = ExoPlayer.Builder(application.applicationContext)
            .build().also { exoPlayer ->
                if (trackSelectionParameters != null) {
                    exoPlayer.trackSelectionParameters = trackSelectionParameters!!
                }
                if (subtitlesUriListState.value.isNotEmpty()) {
                    setMediaItemWithSubtitleTrack(subtitlesUriListState.value)
                } else {
                    exoPlayer.setMediaItem(currentPlayingMediaItem!!)
                }

                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(playBackPosition)
                exoPlayer.prepare()

            }
    }

    fun releasePlayer() {
        player?.let { exoPlayer ->
            playWhenReady = exoPlayer.playWhenReady
            playBackPosition = exoPlayer.currentPosition
            updateCurrentMediaItem(exoPlayer.currentMediaItem)
            trackSelectionParameters = exoPlayer.trackSelectionParameters
            exoPlayer.release()
        }
        player = null
    }

    fun setMediaItemWithSubtitleTrack(subUriList: List<Subtitle>) {
        if (subUriList.isNotEmpty()) {
            val currentMediaItem = currentPlayingMediaItem
            val currentPosition = playBackPosition
            val subtitleConfigurationList = mutableListOf<MediaItem.SubtitleConfiguration>()
            subUriList.onEach { subtitle ->
                val uri = subtitle.uri
                val title = subtitle.title
                if (uri != null) {
                    val subtitleConfiguration = MediaItem.SubtitleConfiguration.Builder(uri)
                        .setMimeType(MimeTypes.APPLICATION_SUBRIP)
                        .also {
                            if (title != null) {
                                it.setLabel(title)
                            }
                        }
                        .build()
                    subtitleConfigurationList.add(subtitleConfiguration)
                }
            }
            val updatedMediaItem =
                currentMediaItem?.buildUpon()
                    ?.setSubtitleConfigurations(subtitleConfigurationList)
                    ?.build()

            if (updatedMediaItem != null) {
                println("player set updated media item")
                player?.setMediaItem(updatedMediaItem, currentPosition)
            }
        }
    }

//    fun addStreamSubtitles(streamSubtitleList: List<StreamSubtitle>) {
//        if (streamSubtitleList.isNotEmpty()) {
//            val currentMediaItem = currentPlayingMediaItem
//            val currentPosition = playBackPosition
//            val subtitleConfigurationList = mutableListOf<MediaItem.SubtitleConfiguration>()
//            streamSubtitleList.onEach { subtitle ->
//                val uri = Uri.parse(subtitle.subtitleStreamUrl)
//                val title = subtitle.displayName
//                if (uri != null) {
//                    val subtitleConfiguration = MediaItem.SubtitleConfiguration.Builder(uri)
//                        .setMimeType(MimeTypes.APPLICATION_TTML)
//                        .also {
//                            it.setLabel(title)
//                        }
//                        .build()
//                    subtitleConfigurationList.add(subtitleConfiguration)
//                }
//            }
//            val updatedMediaItem =
//                currentMediaItem?.buildUpon()
//                    ?.setSubtitleConfigurations(subtitleConfigurationList)
//                    ?.build()
//
//            if (updatedMediaItem != null) {
//                println("player set updated media item")
//                player?.setMediaItem(updatedMediaItem, currentPosition)
//            }
//        }
//    }

    fun initializeSubtitleHeader(text: String) {
        _subtitleHeaderState.update {
            it.copy(
                currentText = text,
                originalText = text,
                isOriginalShowing = true
            )
        }

    }

    fun updateCurrentSubText(text: String) {
        _subtitleHeaderState.update { it.copy(currentText = text) }
    }

    fun translateText(
        originalString: String,
        sourceLanguage: String,
        targetLanguage: String
    ) {
        _translatorState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val translateResult = mlKitTranslationService.translate(
                originalString,
                sourceLanguage,
                targetLanguage
            )
            when (translateResult) {
                is Resource.Error -> _translatorState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = translateResult.exception.message
                            ?: application.applicationContext.getString(R.string.error_while_translating)
                    )
                }

                is Resource.Success -> _translatorState.update {
                    it.copy(
                        isLoading = false,
                        translateResult = translateResult.data
                    )
                }
            }
        }
    }

    fun splitIntoWords(subtitleString: String) {
        _wordsChipGroupState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            if (openNLPTokenizer == null) {
                println("model initialised")
                openNLPTokenizer = OpenNLPTokenizer(context = application.applicationContext)
                openNLPTokenizer?.initialize()
            }
            try {
                val tokens = openNLPTokenizer?.tokenizeString(subtitleString)
                _wordsChipGroupState.update { it.copy(isLoading = false, words = tokens) }
            } catch (e: Exception) {
                _wordsChipGroupState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.message
                            ?: application.applicationContext.getString(R.string.error_while_tokenizing)
                    )
                }
            }
        }
    }

    fun changeTargetLanguage(targetLanguage: String) {
        _translatorState.update { it.copy(currentTargetLang = targetLanguage) }
    }

    fun changeOriginalSubShowingState(isShowing: Boolean) {
        _subtitleHeaderState.update { it.copy(isOriginalShowing = isShowing) }
    }

    fun releaseTokenizerModel() {
        println("release model")
        openNLPTokenizer?.release()
        openNLPTokenizer = null
    }

    private suspend fun getMediaItemFromSource(
        videoUri: Uri?,
        videoUriType: VideoUriType
    ) {
        if (videoUri != null) {
            when (videoUriType) {
                VideoUriType.ONLINE_STREAM -> getOnlineStream(videoUri)
                else -> currentPlayingMediaItem = MediaItem.fromUri(videoUri)
            }
        }
    }

    private suspend fun getOnlineStream(videoUri: Uri) {
        println("VideoUri passed to stream: ${videoUri}")
        val youtubeStreamResource = videoRepository.getYoutubeStream(videoUri.toString())
        when (youtubeStreamResource) {
            is Resource.Error -> {
                UIUtils.showToast(
                    application.applicationContext,
                    youtubeStreamResource.exception.message
                )
                println("Stream Error")
            }

            is Resource.Success -> {
                youtubeStream = youtubeStreamResource.data
                println("StreamVideo $youtubeStream")
                youtubeStream?.let {
                    setVideoTitle(it.title)

                    // playing the first stream in the list initially
                    val mediaItem = MediaItem.fromUri(it.videoOnlyStreams[0].streamUrl)

                    val youtubeStreamSubtitleConfiguration =
                        getSubtitleConfigListForYoutubeStream(it.streamSubtitle)

                    currentPlayingMediaItem = if (youtubeStreamSubtitleConfiguration != null) {
                        mediaItem
                            .buildUpon()
                            .setSubtitleConfigurations(youtubeStreamSubtitleConfiguration)
                            .build()
                    } else {
                        mediaItem
                    }
                }

            }
        }
    }

    fun getVideoQualityTracksText(): List<String>? {
        return youtubeStream?.let { stream -> stream.videoOnlyStreams.map { it.resolution } }
    }

    private fun getSubtitleConfigListForYoutubeStream(subtitleStreamList: List<StreamSubtitle?>?): List<SubtitleConfiguration>? {
        return subtitleStreamList?.map { streamSubtitle ->
            val streamUri = Uri.parse(streamSubtitle?.subtitleStreamUrl)
            SubtitleConfiguration.Builder(streamUri)
                .setLabel(streamSubtitle?.displayName)
                .setMimeType(MimeTypes.APPLICATION_TTML)
                .build()
        }
    }

    fun onVideoQualityChanged(videoQualityTrackIndex: Int) {
//        val mediaSource =
//        MergingMediaSource(true)
        if (videoQualityTrackIndex != chosenQualityListItemIndex) {
            chosenQualityListItemIndex = videoQualityTrackIndex
            player?.let {
                playBackPosition = it.currentPosition
                playWhenReady = true
                it.pause()
            }
            val qualityString = getVideoQualityTracksText()?.get(videoQualityTrackIndex)
            val chosenStream =
                youtubeStream?.videoOnlyStreams?.first { it.resolution == qualityString }?.streamUrl
            val updatedMediaItem = MediaItem.fromUri(chosenStream!!)
            // TODO: not sure if it's right to also set the subtitle configs again when video quality is changed
//            val subtitleConfiguration =
//                getSubtitleConfigListForYoutubeStream(youtubeStream?.streamSubtitle)
//            if (!subtitleConfiguration.isNullOrEmpty()) {
//                updatedMediaItem.buildUpon().setSubtitleConfigurations(subtitleConfiguration)
//                    .build()
//            }
            updateVideoMedia(updatedMediaItem)
        }
    }

    private fun updateVideoMedia(updatedMediaItem: MediaItem) {
        player?.let { exoPlayer ->
            currentPlayingMediaItem?.run {
                exoPlayer.setMediaItem(updatedMediaItem)
                exoPlayer.seekTo(playBackPosition)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.prepare()
            }
        }
    }
}

enum class VideoUriType {
    ONLINE_STREAM,
    LOCAL,
    LOCAL_OUTSIDE
}
