package com.parneet.smartlayer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Size
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
        loadVideos(bucketId)
        }
    }

    private suspend fun loadVideos(bucketId: String?) {
        val videosList = VideoManager.getVideosInFolder(
            requireActivity().applicationContext,
            bucketId!!
        ) { widthInDp, heightInDp ->
            val density = resources.displayMetrics.density.toInt()
            Size(widthInDp * density, heightInDp * density)
        }
        if (videosList != null) {
            val videosListAdapter = VideoListAdapter(videosList) { uri ->
                startPlayer(uri)
            }
            binding.videoListRecyclerView.adapter = videosListAdapter
        }
    }

    private fun startPlayer(uri: Uri) {
        val startPlayerIntent = Intent(requireContext(), PlayerActivity::class.java)
        startPlayerIntent.putExtra(FolderListFragment.EXTRA_VIDEO_URI, uri)
        startActivity(startPlayerIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}