package com.parneet.smartlayer

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import com.google.android.material.chip.Chip
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
        setInfoIconVisible(true)
        binding.playerView.setFullscreenButtonClickListener { }

        binding.includedInfoLayout.googleSearchButton.setOnClickListener {
            // trigger web dialog search dialog
        }

        viewModel.currentSubText.observe(this) { currentText ->
            binding.includedInfoLayout.originalTextView.text = currentText
        }
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
                if (viewModel.videoUri != null) {
                    exoPlayer.setMediaItem(MediaItem.fromUri(viewModel.videoUri!!))
                }

                getInfoButton().setOnClickListener {
                    infoButtonClickListener(exoPlayer)
                }

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

    private fun getInfoButton(): ImageButton {
        return binding.playerView.findViewById(R.id.custom_info_button)
    }

    private fun setInfoIconVisible(visibility: Boolean) {
        val view = getInfoButton()
        when (visibility) {
            true -> view.visibility = View.VISIBLE
            false -> view.visibility = View.GONE
        }
    }

    private fun infoButtonClickListener(exoPlayer: Player) {
        if (exoPlayer.isCommandAvailable(Player.COMMAND_GET_TEXT)) {
            val cueGroup = exoPlayer.currentCues
            val cueSize = cueGroup.cues.size
            if (cueSize != 0) {
                val text = cueGroup.cues[cueSize - 1].text.toString()
                exoPlayer.pause()
                openInfoDrawer(text)
                logDebug(text)
            }
        }
    }

    private fun openInfoDrawer(text: String) {
        viewModel.originalSubText = text
        binding.drawerLayout.open()
        viewModel.updateCurrentSubText(text)
        binding.includedInfoLayout.wordsChipGroup.removeAllViews()
        // extract words from line
        val words = text.split(" ")
        for (word in words) {
            createWordChip(word.trim())
        }
    }

    private fun createWordChip(word: String) {
        val inflatedChip: Chip = layoutInflater.inflate(
            R.layout.word_chip,
            binding.includedInfoLayout.wordsChipGroup,
            false
        ) as Chip
        inflatedChip.id = View.generateViewId()
        inflatedChip.text = word
        inflatedChip.setOnCheckedChangeListener { buttonView, isChecked ->
            if (viewModel.isOriginalSubShowing) {
                viewModel.updateCurrentSubText("")
                viewModel.isOriginalSubShowing = false
            }
            if (isChecked) {
                // chip selected
                logDebug(buttonView.text.toString())
                val text = buttonView.text.toString()
                val modifiedText = viewModel.currentSubText.value?.plus(" ").plus(text)
                viewModel.updateCurrentSubText(modifiedText)
            } else {
                // chip unselected
                viewModel.updateCurrentSubText(viewModel.currentSubText.value?.replace(word, ""))
            }
            if (binding.includedInfoLayout.wordsChipGroup.checkedChipIds.size == 0) {
                viewModel.updateCurrentSubText(viewModel.originalSubText)
                viewModel.isOriginalSubShowing = true
            }
        }
        binding.includedInfoLayout.wordsChipGroup.addView(inflatedChip)
    }
}