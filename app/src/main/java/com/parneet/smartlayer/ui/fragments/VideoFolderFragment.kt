package com.parneet.smartlayer.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.FragmentVideoFolderBinding
import com.parneet.smartlayer.model.Video
import com.parneet.smartlayer.ui.activities.PlayerActivity
import com.parneet.smartlayer.ui.util.UIUtils
import com.parneet.smartlayer.ui.viewmodels.VideoListFragmentViewModel
import kotlinx.coroutines.launch

class VideoFolderFragment : Fragment() {
    private var _binding: FragmentVideoFolderBinding? = null
    private val binding get() = _binding!!
    private val viewModel: VideoListFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bucketDisplayName = arguments?.getString(FolderListFragment.EXTRA_BUCKET_DISPLAY_NAME)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = bucketDisplayName
    }

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

        // TODO: See if we can create and pass interface (defining all the actions needed by popup menu)
        observeState()
        viewModel.initializeAdapter(onItemClick = { uri, title ->
            startPlayer(uri, title)
        }, onShareMenuItemClick = { uri ->
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "video/*"
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(shareIntent)
        },
            onDetailsMenuItemClick = { video ->
                navigateToDetailsScreen(video)
            })

        binding.videoListRecyclerView.adapter = viewModel.videoListAdapter
        if (bucketId != null) {
            viewModel.loadVideos(bucketId)
        } else {
            // bucket is null
        }
    }

    private fun navigateToDetailsScreen(video: Video) {
        val bundle = Bundle().also { it.putParcelable(EXTRA_VIDEO,video) }
        findNavController().navigate(R.id.action_videoFolderFragment_to_videoDetailsFragment,bundle)
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    UIUtils.toggleLoading(
                        state.isLoading,
                        binding.videoListRecyclerView,
                        binding.progressCircular
                    )
                    when {
                        (state.errorMessage.isNotEmpty()) -> UIUtils.showSnackBar(
                            binding.root,
                            state.errorMessage
                        )

                        (state.isListEmpty) -> UIUtils.showSnackBar(
                            binding.root,
                            getString(R.string.no_videos)
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
        const val EXTRA_VIDEO = "EXTRA_VIDEO"
    }
}