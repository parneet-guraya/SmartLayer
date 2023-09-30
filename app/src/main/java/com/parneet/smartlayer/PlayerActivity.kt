package com.parneet.smartlayer

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import com.google.android.material.chip.Chip
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.parneet.smartlayer.databinding.ActivityPlayerBinding
import com.parneet.smartlayer.model.Response
import com.parneet.smartlayer.service.MlKitTranslationService


@OptIn(UnstableApi::class)
class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private val viewModel: PlayerViewModel by viewModels()
    private var player: ExoPlayer? = null
    private var windowInsetsController: WindowInsetsControllerCompat? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        viewModel.videoUri = intent.getParcelableExtra(
            MainActivity.EXTRA_VIDEO_URI
        )
        setInfoIconVisible(true)

        initWindowInsetsController()
        binding.playerView.setFullscreenButtonClickListener { isFullScreen ->
            if (isFullScreen) {
                enterImmersiveMode()
                askToAI("Translate this sentence --> What can one do about it???")

            } else {
                exitImmersiveMode()
            }

        }


        viewModel.currentSubText.observe(this) { currentText ->
            binding.includedInfoLayout.originalTextView.text = currentText
            translateText(currentText!!, viewModel.currentTargetLang)
        }

        (binding.includedInfoLayout.targetLanguageSpinner.editText as? MaterialAutoCompleteTextView)?.apply {
            setSimpleItems(MlKitTranslationService.langMap.keys.toTypedArray())
            setSelection(0)
            setOnItemClickListener { _, view, _, _ ->
                val textView = view as TextView
                logDebug(textView.text.toString())
                viewModel.currentTargetLang =
                    MlKitTranslationService.langMap[textView.text.toString()]!!
                translateText(
                    binding.includedInfoLayout.originalTextView.text.toString(),
                    viewModel.currentTargetLang
                )
            }
        }

        binding.drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            }

            override fun onDrawerOpened(drawerView: View) {
                player?.pause()
            }

            override fun onDrawerClosed(drawerView: View) {
                player?.play()
            }

            override fun onDrawerStateChanged(newState: Int) {
            }

        })
    }

    private fun translateText(text: String, targetLanguage: String) {
        viewModel.translateResponseState.observe(this) { response ->
            when (response) {
                is Response.Error -> logDebug("Translate text" + response.exception.message!!)
                is Response.Loading -> {
                    showLoading(
                        true,
                        binding.includedInfoLayout.translatedTextView,
                        binding.includedInfoLayout.translateLoadingBar
                    )
                    logDebug("Translate Loading")
                }

                is Response.Success -> {
                    showLoading(
                        false,
                        binding.includedInfoLayout.translatedTextView,
                        binding.includedInfoLayout.translateLoadingBar
                    )
                    logDebug("Translate result: ${response.data}")
                    binding.includedInfoLayout.translatedTextView.text = response.data
                }
            }
        }
        viewModel.translateText(text, viewModel.currentSourceLang, targetLanguage)
    }

    private fun showLoading(show: Boolean, view: View, loadingView: LinearProgressIndicator) {
        if (show) {
            loadingView.visibility = View.VISIBLE
            view.visibility = View.GONE
            loadingView.show()
        } else {
            loadingView.visibility = View.GONE
            view.visibility = View.VISIBLE
        }
    }

    private fun askToAI(promptText: String) {
        viewModel.generativeTextResponse.observe(this) { response ->
            when (response) {
                is Response.Error -> logDebug("AI service: " + response.exception.message!!)
                is Response.Loading -> logDebug("Loading")
                is Response.Success -> {
                    logDebug(response.data.output)
                    binding.includedInfoLayout.generatedTextView.text = response.data.output
                }
            }
        }
        viewModel.promptToAI(promptText)
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

    private fun initWindowInsetsController() {
        windowInsetsController = WindowCompat.getInsetsController(
            window, window.decorView
        )
        windowInsetsController?.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
    }

    private fun enterImmersiveMode() {
        val type = WindowInsetsCompat.Type.systemBars()
        windowInsetsController?.hide(type)
    }

    private fun exitImmersiveMode() {
        val type = WindowInsetsCompat.Type.systemBars()
        windowInsetsController?.show(type)
    }
}