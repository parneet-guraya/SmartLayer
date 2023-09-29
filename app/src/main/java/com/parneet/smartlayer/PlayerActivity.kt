package com.parneet.smartlayer

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import com.parneet.smartlayer.databinding.ActivityPlayerBinding

@OptIn(UnstableApi::class)

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private val viewModel: PlayerViewModel by viewModels()
    private var player: ExoPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.videoUri = intent.getParcelableExtra(
            MainActivity.EXTRA_VIDEO_URI
        )

        binding.playerView.setFullscreenButtonClickListener { }

    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    private fun initializePlayer() {
        val trackSelector = DefaultTrackSelector(this, AdaptiveTrackSelection.Factory())

        player = ExoPlayer.Builder(this)
            .setTrackSelector(trackSelector)
            .build().also { exoPlayer ->
                binding.playerView.player = exoPlayer
                exoPlayer.setMediaItem(MediaItem.fromUri(viewModel.videoUri!!))
                exoPlayer.playWhenReady = viewModel.playWhenReady
                exoPlayer.seekTo(viewModel.playBackPosition)
                exoPlayer.prepare()
            }
    }

    private fun releasePlayer() {
        player?.let { exoPlayer ->
            viewModel.playWhenReady = exoPlayer.playWhenReady
            viewModel.playBackPosition = exoPlayer.currentPosition
            exoPlayer.release()
        }
        player = null
    }

}