package com.parneet.smartlayer.ui.fragments

import android.os.Bundle
import android.text.format.Formatter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import com.parneet.smartlayer.R
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.data.video.VideoRepository
import com.parneet.smartlayer.databinding.FragmentVideoDetailsBinding
import com.parneet.smartlayer.model.Video
import com.parneet.smartlayer.model.VideoMetaData
import com.parneet.smartlayer.ui.util.CommonUtils
import com.parneet.smartlayer.ui.util.UIUtils
import kotlinx.coroutines.launch

class VideoDetailsFragment : Fragment() {
    private var _binding: FragmentVideoDetailsBinding? = null
    private val binding get() = _binding!!
    private val videoRepository = VideoRepository()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentVideoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val video = arguments?.getParcelable<Video>(VideoFolderFragment.EXTRA_VIDEO)
        video?.let {
            println("Image Resolution: Width: ${binding.videoThumbnail.width} Height: ${binding.videoThumbnail.height}")
            val applicationContext = requireContext().applicationContext
            lifecycleScope.launch {
                val thumbnailResponse = videoRepository.getVideoThumbnail(
                    applicationContext,
                    video.uri,
                    1280, 720
                )
                when (thumbnailResponse) {
                    is Resource.Error -> {
                        println("getVideoThumbnail response: ${thumbnailResponse.exception}")
                        UIUtils.showSnackBar(
                            binding.root,
                            thumbnailResponse.exception.message
                        )
                    }

                    is Resource.Success -> binding.videoThumbnail.load(thumbnailResponse.data)
                }
            }
            lifecycleScope.launch {
                UIUtils.toggleLoading(true,binding.root,binding.progressCircular)
                val response =
                    videoRepository.getVideoMetaData(applicationContext, it)
                when (response) {
                    is Resource.Error -> {
                        println("getVideoMetaData response: ${response.exception}")
                        UIUtils.toggleLoading(false,binding.root,binding.progressCircular)
                        UIUtils.showSnackBar(
                            binding.root,
                            response.exception.message
                        )
                    }

                    is Resource.Success -> {
                        UIUtils.toggleLoading(false,binding.root,binding.progressCircular)
                        bindData(response.data)
                    }
                }
            }
        }
    }

    private fun bindData(videoMetaData: VideoMetaData) {
        val title = videoMetaData.title
        updateActionBarTitle(title)
        binding.titleTextView.text = title
        binding.durationTextView.text = "${getString(R.string.duration)}: ${CommonUtils.millisToTimeFormat(videoMetaData.duration)}"
        binding.sizeTextView.text = "${getString(R.string.size)}: ${Formatter.formatFileSize(requireContext(),videoMetaData.fileSize)}"
        val resolution = "${getString(R.string.resolution)}: ${videoMetaData.resolution.width} X ${videoMetaData.resolution.height}"
        binding.resolutionTextView.text = resolution
    }

    private fun updateActionBarTitle(title:String){
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}