package com.parneet.smartlayer

import android.graphics.Bitmap
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.parneet.smartlayer.databinding.VideoItemBinding
import com.parneet.smartlayer.model.Resource
import com.parneet.smartlayer.model.Video

class VideoListAdapter(
    private val onItemClick: (uri: Uri, title: String) -> Unit,
    private val loadThumbnail: (uri: Uri) -> Resource<Bitmap?>,
) : ListAdapter<Video, VideoListAdapter.VideoItemViewHolder>(VideoItemDiffUtil) {

    class VideoItemViewHolder(
        binding: VideoItemBinding,
        videosList: List<Video>,
        onItemClick: (uri: Uri, title: String) -> Unit
    ) : ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val video = videosList[absoluteAdapterPosition]
                onItemClick(video.uri, video.title)
            }
        }

        val videoThumbnailIV = binding.videoThumbnail
        val videoTitleTV = binding.videoTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoItemViewHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoItemViewHolder(binding, currentList, onItemClick)
    }

    override fun onBindViewHolder(holder: VideoItemViewHolder, position: Int) {
        val video = currentList[position]
        val result = loadThumbnail(video.uri)
        when (result) {
            is Resource.Failure -> logDebug(result.exception.message!!)
            is Resource.Success -> {
                holder.videoThumbnailIV.load(result.data) {
                    crossfade(true)
                    placeholder(R.color.black)
                }
            }
        }

        holder.videoTitleTV.text = video.title
    }
}

object VideoItemDiffUtil : DiffUtil.ItemCallback<Video>() {
    override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.uri == newItem.uri &&
                oldItem.duration == newItem.duration
    }

}