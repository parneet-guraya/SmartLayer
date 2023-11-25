package com.parneet.smartlayer.ui.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.ActivityPlayerBinding
import com.parneet.smartlayer.common.Response
import com.parneet.smartlayer.ui.fragments.VideoFolderFragment
import com.parneet.smartlayer.ui.fragments.WebSearchDialogFragment
import com.parneet.smartlayer.ui.fragments.WikipediaArticlesDialogFragment
import com.parneet.smartlayer.ui.service.translation.TranslateService
import com.parneet.smartlayer.ui.util.AppUtils
import com.parneet.smartlayer.ui.viewmodels.PlayerViewModel
import kotlinx.coroutines.launch


@OptIn(UnstableApi::class)
class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private val viewModel: PlayerViewModel by viewModels()
    private var player: ExoPlayer? = null
    private var windowInsetsController: WindowInsetsControllerCompat? = null
    private val subPickerLauncher: ActivityResultLauncher<Intent> = onGetSub()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.attributes.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER
        }
        viewModel.videoUri = intent.getParcelableExtra(
            VideoFolderFragment.EXTRA_VIDEO_URI
        )
        val title = intent?.getStringExtra(VideoFolderFragment.EXTRA_VIDEO_TITLE)
        getVideoTitleView().text = title
        setInfoIconVisible(true)
        getBackArrowButton().setOnClickListener {
            super.onBackPressed()
        }
        initWindowInsetsController()
        binding.playerView.setFullscreenButtonClickListener { isFullScreen ->
            if (isFullScreen) {
                enterImmersiveMode()
            } else {
                exitImmersiveMode()
            }

        }

        viewModel.tokenizedWords.observe(this) { tokenizingResponse ->
            when (tokenizingResponse) {
                is Response.Error -> logDebug("Error: ${tokenizingResponse.exception} while tokenizing")
                is Response.Loading -> {
                    AppUtils.toggleLoading(
                        tokenizingResponse.isLoading,
                        binding.includedInfoLayout.wordsChipGroup,
                        binding.includedInfoLayout.splittingWordsProgressIndicator
                    )
                }

                is Response.Success -> {
                    tokenizingResponse.data?.onEach { word ->
                        createWordChip(word)
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.translateResponseState.collect { response ->
                    println("Translation: $response")
                    when (response) {
                        is Response.Error -> binding.includedInfoLayout.translatedTextView.text =
                            response.message.toString()

                        is Response.Loading -> {
                            AppUtils.toggleLoading(
                                response.isLoading,
                                binding.includedInfoLayout.translatedTextView,
                                binding.includedInfoLayout.translateLoadingBar
                            )
                            logDebug("Translate Loading")
                        }

                        is Response.Success -> {
                            logDebug("Translate result: ${response.data}")
                            binding.includedInfoLayout.translatedTextView.text = response.data
                        }
                    }
                }
            }
        }
        viewModel.currentSubText.observe(this) { currentText ->
            binding.includedInfoLayout.originalTextView.text = currentText
            viewModel.translateText(
                currentText!!,
                viewModel.currentSourceLang,
                viewModel.currentTargetLang
            )
        }

        (binding.includedInfoLayout.targetLanguageSpinner.editText as? MaterialAutoCompleteTextView)?.apply {
            setSimpleItems(TranslateService.langMap.keys.toTypedArray())
            setOnItemClickListener { _, view, _, _ ->
                val textView = view as TextView
                logDebug(textView.text.toString())
                viewModel.currentTargetLang =
                    TranslateService.langMap[textView.text.toString()]!!
                viewModel.translateText(
                    binding.includedInfoLayout.originalTextView.text.toString(),
                    viewModel.currentSourceLang,
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

        binding.includedInfoLayout.webSearchButton.setOnClickListener {
            // launch google search web view dialog
            launchWebViewDialog(
                WebSearchDialogFragment.GOOGLE_SEARCH,
                binding.includedInfoLayout.originalTextView.text.toString()
            )
        }
        binding.includedInfoLayout.wikiSearchButton.setOnClickListener {
            launchWikiArticlesDialog()
        }
    }

    private fun launchWebViewDialog(webOperation: Int, data: String) {
        val dialog = WebSearchDialogFragment()
        val bundle = Bundle()
        when (webOperation) {
            WebSearchDialogFragment.GOOGLE_SEARCH -> {
                bundle.putInt(
                    WebSearchDialogFragment.KEY_WEB_OPERATION,
                    WebSearchDialogFragment.GOOGLE_SEARCH
                )
            }

            WebSearchDialogFragment.WIKI_ARTICLE_PAGE -> {
                bundle.putInt(
                    WebSearchDialogFragment.KEY_WEB_OPERATION,
                    WebSearchDialogFragment.WIKI_ARTICLE_PAGE
                )

            }

            else -> {
                return
            }
        }
        bundle.putString(WebSearchDialogFragment.KEY_URL_EXTRA_DATA_STRING, data)

        dialog.arguments = bundle
        dialog.show(supportFragmentManager, null)
    }

    private fun launchWikiArticlesDialog() {
        val wikiDialog =
            WikipediaArticlesDialogFragment() { pageId ->
                launchWebViewDialog(
                    WebSearchDialogFragment.WIKI_ARTICLE_PAGE,
                    pageId.toString()
                )
            }
        wikiDialog.arguments = Bundle().apply {
            putString(
                WikipediaArticlesDialogFragment.KEY_SEARCH_QUERY,
                binding.includedInfoLayout.originalTextView.text.toString()
            )
        }
        wikiDialog.show(supportFragmentManager, null)
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onStop() {
        super.onStop()
        viewModel.releaseTokenizerModel()
    }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this)
            .build().also { exoPlayer ->
                if (viewModel.trackSelectionParameters != null) {
                    exoPlayer.trackSelectionParameters = viewModel.trackSelectionParameters!!
                }
                binding.playerView.player = exoPlayer
                if (viewModel.currentPlayingMediaItem == null) {
                    val mediaItem = MediaItem.fromUri(viewModel.videoUri!!)
                    viewModel.currentPlayingMediaItem = mediaItem
                }
                if (viewModel.subtitleUri != null) {
                    setMediaItemWithSubtitleTrack(viewModel.subtitleUri)
                } else {
                    exoPlayer.setMediaItem(viewModel.currentPlayingMediaItem!!)
                }

                getInfoButton().setOnClickListener {
                    infoButtonClickListener(exoPlayer)
                }

                getAddSubButton().setOnClickListener {
                    launchSubPicker()
                }

                exoPlayer.playWhenReady = viewModel.playWhenReady
                exoPlayer.seekTo(viewModel.playBackPosition)
                exoPlayer.prepare()

            }
        viewModel.subtitleUri?.let { subUri ->
            println("add subtitle Uri: $subUri")
            setMediaItemWithSubtitleTrack(subUri)
        }
    }

    private fun releasePlayer() {
        player?.let { exoPlayer ->
            viewModel.playWhenReady = exoPlayer.playWhenReady
            viewModel.playBackPosition = exoPlayer.currentPosition
            viewModel.currentPlayingMediaItem = exoPlayer.currentMediaItem
            viewModel.trackSelectionParameters = exoPlayer.trackSelectionParameters
            exoPlayer.release()
        }
        player = null
    }

    private fun getInfoButton(): ImageButton {
        return binding.playerView.findViewById(R.id.custom_info_button)
    }

    private fun getAddSubButton(): ImageButton {
        return binding.playerView.findViewById(R.id.add_subtitle_button)
    }

    private fun getVideoTitleView(): TextView {
        return binding.playerView.findViewById(R.id.video_title)
    }

    private fun getBackArrowButton(): ImageButton {
        return binding.playerView.findViewById(R.id.back_arrow_button)
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


    private fun launchSubPicker() {
        val subPickerIntent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = MimeTypes.APPLICATION_SUBRIP
        }
        subPickerLauncher.launch(subPickerIntent)
    }

    private fun onGetSub(): ActivityResultLauncher<Intent> {
        return registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                val intent = activityResult.data
                if (intent != null) {
                    viewModel.subtitleUri = intent.data
                    setMediaItemWithSubtitleTrack(viewModel.subtitleUri)
                }
            }

        }
    }

    private fun setMediaItemWithSubtitleTrack(uri: Uri?) {
        if (uri != null) {
            val currentMediaItem = viewModel.currentPlayingMediaItem
            val currentPosition = viewModel.playBackPosition
            val subtitleConfiguration = MediaItem.SubtitleConfiguration.Builder(uri)
                .setMimeType(MimeTypes.APPLICATION_SUBRIP).setLabel("Default").build()
            val updatedMediaItem =
                currentMediaItem?.buildUpon()
                    ?.setSubtitleConfigurations(listOf(subtitleConfiguration))
                    ?.build()

            if (updatedMediaItem != null) {
                println("player set updated media item")
                player?.setMediaItem(updatedMediaItem, currentPosition)
            }
        }
    }

    private fun openInfoDrawer(text: String) {
        viewModel.isOriginalSubShowing = true
        viewModel.originalSubText = text
        binding.drawerLayout.open()
        viewModel.updateCurrentSubText(text)
        binding.includedInfoLayout.wordsChipGroup.removeAllViews()
        // extract words from line
        viewModel.splitIntoWords(text)
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
        windowInsetsController?.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
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