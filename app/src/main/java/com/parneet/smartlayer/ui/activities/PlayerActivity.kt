package com.parneet.smartlayer.ui.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.marginBottom
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.media3.common.C.TRACK_TYPE_TEXT
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.DefaultTimeBar
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.ActivityPlayerBinding
import com.parneet.smartlayer.ui.fragments.VideoFolderFragment
import com.parneet.smartlayer.ui.fragments.dialog.WebSearchDialogFragment
import com.parneet.smartlayer.ui.fragments.dialog.WikipediaArticlesDialogFragment
import com.parneet.smartlayer.ui.service.translation.MlKitTranslationService
import com.parneet.smartlayer.ui.util.UIUtils
import com.parneet.smartlayer.ui.viewmodels.PlayerViewModel
import kotlinx.coroutines.launch


@OptIn(UnstableApi::class)
class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private val viewModel: PlayerViewModel by viewModels()
    private var windowInsetsController: WindowInsetsControllerCompat? = null
    private val subPickerLauncher: ActivityResultLauncher<Intent> = onGetSub()
    private var drawerBackPressCallback: OnBackPressedCallback? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val title = intent?.getStringExtra(VideoFolderFragment.EXTRA_VIDEO_TITLE)
        getVideoTitleView().text = title
        getBackArrowButton().setOnClickListener {
            super.onBackPressed()
        }
        drawerBackPressCallback = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                binding.drawerLayout.close()
            }

        }
        onBackPressedDispatcher.addCallback(drawerBackPressCallback!!)

        initWindowInsetsController()
        applyWindowInsets()
        enterImmersiveMode()
        var uri: Uri? = intent.getParcelableExtra(
            VideoFolderFragment.EXTRA_VIDEO_URI
        )
        if (uri == null) {
            if (intent.action == Intent.ACTION_VIEW) {
                uri = intent?.data
            } else if (intent.action == Intent.ACTION_SEND) {
                val intentString = intent?.getStringExtra(Intent.EXTRA_TEXT)
                uri = Uri.parse(intentString)
                println(intentString)
            }
        }

        viewModel.setCurrentMedia(uri)
        observeViewStates()
        initializeTranslatorSpinner()
        addListeners()
    }

    private fun observeViewStates() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // subtitles list state
                launch {
                    viewModel.subtitlesUriListState.collect { subUriList ->
                        viewModel.setMediaItemWithSubtitleTrack(subUriList)
                    }
                }

                // subtitle header state
                launch {
                    viewModel.subtitleHeaderState.collect { state ->
                        binding.includedInfoLayout.originalTextView.text = state.currentText
                        viewModel.translateText(
                            state.currentText,
                            viewModel.translatorState.value.currentSourceLang,
                            viewModel.translatorState.value.currentTargetLang
                        )
                    }
                }
                // words chip group state
                launch {
                    viewModel.wordsChipGroupState.collect { state ->
                        binding.includedInfoLayout.wordsChipGroup.removeAllViews()
                        UIUtils.toggleLoading(
                            state.isLoading,
                            null,
                            binding.includedInfoLayout.splittingWordsProgressIndicator
                        )
                        when {
                            (state.errorMessage.isNotEmpty()) -> {}

                            (!state.words.isNullOrEmpty()) -> {
                                state.words.onEach { word ->
                                    createWordChip(word)
                                }
                            }

                            else -> {}
                        }

                    }
                }
                // translator state
                launch {
                    viewModel.translatorState.collect { state ->
                        UIUtils.toggleLoading(
                            state.isLoading,
                            binding.includedInfoLayout.translatedTextView,
                            binding.includedInfoLayout.translateLoadingBar
                        )
                        when {
                            (state.errorMessage.isNotEmpty()) -> UIUtils.showSnackBar(
                                binding.root,
                                state.errorMessage
                            )

                            (state.translateResult.isNotEmpty()) -> binding.includedInfoLayout.translatedTextView.text =
                                state.translateResult
                        }
                    }
                }
            }
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

    private fun launchWikiArticlesDialog(query: String) {
        val wikiDialog =
            WikipediaArticlesDialogFragment { pageId ->
                launchWebViewDialog(
                    WebSearchDialogFragment.WIKI_ARTICLE_PAGE,
                    pageId.toString()
                )
            }
        wikiDialog.arguments = Bundle().apply {
            putString(
                WikipediaArticlesDialogFragment.KEY_SEARCH_QUERY,
                query
            )
        }
        wikiDialog.show(supportFragmentManager, null)
    }

    private fun initializeTranslatorSpinner() {
        (binding.includedInfoLayout.targetLanguageSpinner.editText as? MaterialAutoCompleteTextView)?.apply {
            setSimpleItems(MlKitTranslationService.langMap.keys.toTypedArray())
            setOnItemClickListener { _, view, _, _ ->
                val textView = view as TextView
                val selectedTargetLang = MlKitTranslationService.langMap[textView.text.toString()]!!
                viewModel.changeTargetLanguage(selectedTargetLang)
                viewModel.translateText(
                    binding.includedInfoLayout.originalTextView.text.toString(),
                    viewModel.translatorState.value.currentSourceLang,
                    viewModel.translatorState.value.currentTargetLang
                )
            }
        }
    }

    private fun addDrawerListener() {
        binding.drawerLayout.let {
            it.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            it.addDrawerListener(object : DrawerLayout.DrawerListener {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                }

                override fun onDrawerOpened(drawerView: View) {
                    drawerBackPressCallback?.isEnabled = true
                    viewModel.player?.pause()
                    updateInfoDrawerText(viewModel.currentText)
                }

                override fun onDrawerClosed(drawerView: View) {
                    drawerBackPressCallback?.isEnabled = false
                    viewModel.player?.play()
                }

                override fun onDrawerStateChanged(newState: Int) {
                }

            })
        }
    }

    private fun addListeners() {
        addDrawerListener()
        binding.includedInfoLayout.webSearchButton.setOnClickListener {
            // launch google search web view dialog
            launchWebViewDialog(
                WebSearchDialogFragment.GOOGLE_SEARCH,
                binding.includedInfoLayout.originalTextView.text.toString()
            )
        }
        binding.includedInfoLayout.wikiSearchButton.setOnClickListener {
            launchWikiArticlesDialog(binding.includedInfoLayout.originalTextView.text.toString())
        }
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
        viewModel.releasePlayer()
    }

    private fun initializePlayer() {
        viewModel.initializeMediaPlayer()
        binding.playerView.player = viewModel.player
        println(
            "Initialize player subs available: ${
                viewModel.player?.currentTracks?.containsType(
                    TRACK_TYPE_TEXT
                )
            }"
        )
        getInfoButton().let {
            it.setOnClickListener {
                if (showInfoDrawerIfAvailable()) {
                    viewModel.currentText = getSubtitleText()
                    binding.drawerLayout.open()
                }
            }
        }

        getAddSubButton().setOnClickListener {
            launchSubPicker()
        }
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

    private fun getPlayerTopBar(): FrameLayout {
        return binding.playerView.findViewById(R.id.exo_top_bar)
    }

    private fun showInfoDrawerIfAvailable(): Boolean {
        val exoPlayer = viewModel.player
        if (exoPlayer != null) {
            val cueGroup = exoPlayer.currentCues
            val cueSize = cueGroup.cues.size
            return cueSize != 0
        }
        return false
    }

    private fun getSubtitleText(): String? {
        return viewModel.player?.let {
            val cueGroup = it.currentCues
            val cueSize = cueGroup.cues.size
            val text = cueGroup.cues[cueSize - 1].text.toString()
            return text
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
                    val subUri = intent.data
                    viewModel.addSubtitle(subUri)
                }
            }

        }
    }

    private fun updateInfoDrawerText(text: String?) {
        if (text != null) {
            viewModel.initializeSubtitleHeader(text)
            viewModel.splitIntoWords(text)
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
            if (binding.includedInfoLayout.wordsChipGroup.checkedChipIds.size == 0) {
                viewModel.updateCurrentSubText(viewModel.subtitleHeaderState.value.originalText)
                viewModel.changeOriginalSubShowingState(true)
            } else {
                if (viewModel.subtitleHeaderState.value.isOriginalShowing) {
                    viewModel.updateCurrentSubText("")
                    viewModel.changeOriginalSubShowingState(false)
                }
                if (isChecked) {
                    // chip selected
                    val text = buttonView.text.toString()
                    val modifiedText =
                        viewModel.subtitleHeaderState.value.currentText.plus(" ").plus(text)
                    viewModel.updateCurrentSubText(modifiedText)
                } else {
                    // chip unselected
                    viewModel.updateCurrentSubText(
                        viewModel.subtitleHeaderState.value.currentText.replace(
                            word,
                            ""
                        )
                    )
                }
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

    private fun applyWindowInsets() {
        val playerView = binding.playerView
        val playerBottomBar =
            playerView.findViewById<FrameLayout>(androidx.media3.ui.R.id.exo_bottom_bar)
        val playerTopBar = getPlayerTopBar()
        val playerProgress =
            playerView.findViewById<DefaultTimeBar>(androidx.media3.ui.R.id.exo_progress)
        val progressBottomMargin = playerProgress.marginBottom
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets =
                windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())

            playerTopBar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
            }
            playerBottomBar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                bottomMargin = insets.bottom
            }
            playerProgress.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                bottomMargin = insets.bottom + progressBottomMargin
            }

            playerBottomBar.updatePadding(left = insets.left, right = insets.right)
            playerTopBar.updatePadding(left = insets.left, right = insets.right)
            playerProgress.updatePadding(left = insets.left, right = insets.right)
            binding.includedInfoLayout.root.updatePadding(
                left = insets.left,
                top = insets.top,
                bottom = insets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }
    }
}