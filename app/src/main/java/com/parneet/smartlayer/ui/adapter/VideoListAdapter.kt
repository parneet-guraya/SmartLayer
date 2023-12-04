package com.parneet.smartlayer.ui.adapter

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.parneet.smartlayer.R
import com.parneet.smartlayer.common.Resource
import com.parneet.smartlayer.databinding.VideoItemBinding
import com.parneet.smartlayer.model.Video

class VideoListAdapter(
    private val onItemClick: (uri: Uri, title: String) -> Unit,
    private val loadThumbnail: (uri: Uri) -> Resource<Bitmap?>,
    private val millisToTimeFormat: (durationMillis: Int) -> String,
    private val onPopupMenuItemClick: (menuItemId: Int, uri:Uri) -> Boolean
) : ListAdapter<Video, VideoListAdapter.VideoItemViewHolder>(VideoItemDiffUtil) {

    class VideoItemViewHolder(
        binding: VideoItemBinding,
        private val videosList: List<Video>,
        onItemClick: (uri: Uri, title: String) -> Unit,
        private val onPopupMenuItemClick: (menuItemId: Int, uri:Uri) -> Boolean
    ) : ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val video = videosList[absoluteAdapterPosition]
                onItemClick(video.uri, video.title)
            }
            binding.morePopMenuButton.setOnClickListener {
                showPopupMenu(
                    binding.root.context,
                    binding.morePopMenuButton
                )
            }
        }

        val videoThumbnailIV = binding.videoThumbnail
        val videoTitleTV = binding.videoTitle
        val durationTV = binding.duration

        private fun showPopupMenu(context: Context?, anchorView: View?) {
            val popupMenu = PopupMenu(context, anchorView)
            popupMenu.menuInflater?.inflate(R.menu.video_item_popup_menu, popupMenu.menu)
            val video = videosList[absoluteAdapterPosition]
            popupMenu.setOnMenuItemClickListener { menuItem ->
                onPopupMenuItemClick(menuItem.itemId,video.uri)
            }
            popupMenu.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoItemViewHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoItemViewHolder(binding, currentList, onItemClick, onPopupMenuItemClick)
    }

    override fun onBindViewHolder(holder: VideoItemViewHolder, position: Int) {
        val video = currentList[position]
        val result = loadThumbnail(video.uri)
        when (result) {
            is Resource.Error -> {}
            is Resource.Success -> {
                holder.videoThumbnailIV.load(result.data) {
                    crossfade(true)
                    placeholder(R.color.grey)
                }
            }
        }

        holder.videoTitleTV.text = video.title
        holder.durationTV.text = millisToTimeFormat(video.duration)
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