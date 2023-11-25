package com.parneet.smartlayer.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.parneet.smartlayer.data.video.VideoRepository
import com.parneet.smartlayer.databinding.FragmentVideoFolderBinding
import com.parneet.smartlayer.common.Response
import com.parneet.smartlayer.ui.activities.PlayerActivity
import com.parneet.smartlayer.ui.adapter.VideoListAdapter
import com.parneet.smartlayer.ui.util.AppUtils
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class VideoFolderFragment : Fragment() {
    private var _binding: FragmentVideoFolderBinding? = null
    private val binding get() = _binding!!
    private lateinit var videoListAdapter: VideoListAdapter
    private val videoRepository = VideoRepository()

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

        videoListAdapter =
            VideoListAdapter(
                onItemClick = { uri, title ->
                    startPlayer(uri, title)
                },
                loadThumbnail = { uri ->
                    videoRepository.getVideoThumbnail(
                        requireContext().applicationContext,
                        uri
                    ) { sizeInDp ->
                        AppUtils.dpToPixels(
                            sizeInDp,
                            requireContext().applicationContext
                        )
                    }
                })
        binding.videoListRecyclerView.adapter = videoListAdapter
        lifecycleScope.launch {
            loadVideos(bucketId)
        }
    }

    private suspend fun loadVideos(bucketId: String?) {
        val videoListResponse =
            videoRepository.getVideosInFolder(requireContext().applicationContext, bucketId)
        videoListResponse.collectLatest { videosResponse ->
            println("VideoResponse Flow: $videosResponse")
            when (videosResponse) {
                is Response.Error -> AppUtils.showSnackBar(
                    binding.root,
                    videosResponse.exception?.message
                )

                is Response.Loading -> AppUtils.toggleLoading(
                    videosResponse.isLoading,
                    binding.videoListRecyclerView,
                    binding.progressCircular
                )

                is Response.Success -> {
                    val videosList = videosResponse.data
                    videoListAdapter.submitList(videosList)
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