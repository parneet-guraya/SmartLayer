package com.parneet.smartlayer

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.parneet.smartlayer.databinding.VideoItemBinding
import com.parneet.smartlayer.model.Video

class VideoListAdapter(
    private val videosList: List<Video>,
    private val onItemClick: (uri: Uri,title:String) -> Unit
) : RecyclerView.Adapter<VideoListAdapter.VideoItemViewHolder>() {

    class VideoItemViewHolder(
        binding: VideoItemBinding,
        videosList: List<Video>,
        onItemClick: (uri: Uri,title:String) -> Unit
    ) : ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val video = videosList[absoluteAdapterPosition]
                onItemClick(video.uri,video.title)
            }
        }

        val videoThumbnailIV = binding.videoThumbnail
        val videoTitleTV = binding.videoTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoItemViewHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoItemViewHolder(binding, videosList, onItemClick)
    }

    override fun onBindViewHolder(holder: VideoItemViewHolder, position: Int) {
        val video = videosList[position]
        holder.videoThumbnailIV.load(video.thumbnail)
        holder.videoTitleTV.text = video.title
    }

    override fun getItemCount(): Int {
        return videosList.size
    }
}