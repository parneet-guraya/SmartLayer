package com.parneet.smartlayer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.parneet.smartlayer.databinding.FragmentVideoFolderBinding
import kotlinx.coroutines.launch

class VideoFolderFragment : Fragment() {
    private var _binding: FragmentVideoFolderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoFolderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bucketId = arguments?.getString(FolderListFragment.EXTRA_BUCKET_ID)
        println("BucketId: $bucketId")
        lifecycleScope.launch {
            try {
                AppUtils.toggleLoading(
                    true,
                    binding.videoListRecyclerView,
                    binding.progressCircular
                )
                loadVideos(bucketId)
                AppUtils.toggleLoading(
                    false,
                    binding.videoListRecyclerView,
                    binding.progressCircular
                )
            } catch (e: Exception) {
                AppUtils.toggleLoading(false, null, binding.progressCircular)
                AppUtils.showSnackBar(binding.root, e.message)
            }
        }
    }

    private suspend fun loadVideos(bucketId: String?) {
        val videosList = VideoManager.getVideosInFolder(
            requireContext().applicationContext,
            bucketId!!
        )
        if (videosList != null) {
            val videosListAdapter =
                VideoListAdapter(videosList = videosList,
                    onItemClick = { uri, title ->
                        startPlayer(uri, title)
                    },
                    loadThumbnail = { uri ->
                        VideoManager.loadThumbnail(
                            requireContext().applicationContext,
                            uri
                        ) { sizeInDp ->
                            AppUtils.dpToPixels(sizeInDp, requireContext().applicationContext)
                        }
                    })
            binding.videoListRecyclerView.adapter = videosListAdapter
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