package com.parneet.smartlayer.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.parneet.smartlayer.databinding.FragmentVideoFolderBinding
import com.parneet.smartlayer.ui.activities.PlayerActivity
import com.parneet.smartlayer.ui.activities.logDebug
import com.parneet.smartlayer.ui.util.AppUtils
import com.parneet.smartlayer.ui.viewmodels.VideoListFragmentViewModel
import kotlinx.coroutines.launch

class VideoFolderFragment : Fragment() {
    private var _binding: FragmentVideoFolderBinding? = null
    private val binding get() = _binding!!
    private val viewModel: VideoListFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoFolderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bucketId = arguments?.getString(FolderListFragment.EXTRA_BUCKET_ID)
        println("BucketId: $bucketId")

        observeState()
        viewModel.initializeAdapter { uri, title ->
            startPlayer(uri, title)
        }

        binding.videoListRecyclerView.adapter = viewModel.videoListAdapter
        if (bucketId != null) {
            viewModel.loadVideos(bucketId)
        } else {
            logDebug("BucketId is null")
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    AppUtils.toggleLoading(
                        state.isLoading,
                        binding.videoListRecyclerView,
                        binding.progressCircular
                    )
                    when {
                        (state.errorMessage.isNotEmpty()) -> AppUtils.showSnackBar(
                            binding.root,
                            state.errorMessage
                        )

                        (state.isListEmpty) -> AppUtils.showSnackBar(
                            binding.root,
                            "No Videos"
                        )

                        else -> viewModel.videoListAdapter.submitList(
                            state.videoList
                        )
                    }
                }
            }
        }
    }

    private fun startPlayer(uri: Uri, title: String) {
        val startPlayerIntent = Intent(requireContext(), PlayerActivity::class.java)
        startPlayerIntent.putExtra(EXTRA_VIDEO_URI, uri)
        startPlayerIntent.putExtra(EXTRA_VIDEO_TITLE, title)
        startActivity(startPlayerIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_VIDEO_URI = "EXTRA_VIDEO_URI"
        const val EXTRA_VIDEO_TITLE = "EXTRA_VIDEO_TITLE"
    }
}