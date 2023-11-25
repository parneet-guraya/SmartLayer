package com.parneet.smartlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.parneet.smartlayer.databinding.FolderItemBinding
import com.parneet.smartlayer.model.Folder

class FolderListAdapter(
    private val onItemClick: (bucketId: String) -> Unit
) : ListAdapter<Folder, FolderListAdapter.FolderItemViewHolder>(FolderItemDiffUtil) {

    class FolderItemViewHolder(
        binding: FolderItemBinding,
        foldersList: List<Folder>,
        onItemClick: (bucketId: String) -> Unit
    ) : ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val folder = foldersList[absoluteAdapterPosition]
                onItemClick(folder.bucketId)
            }
        }

        val folderNameTV = binding.folderTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderItemViewHolder {
        return FolderItemViewHolder(
            FolderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            currentList,
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: FolderItemViewHolder, position: Int) {
        val folder = currentList[position]
        holder.folderNameTV.text = folder.bucketDisplayName
    }
}

object FolderItemDiffUtil : DiffUtil.ItemCallback<Folder>() {
    override fun areItemsTheSame(oldItem: Folder, newItem: Folder): Boolean {
        return oldItem.bucketId == newItem.bucketId
    }

    override fun areContentsTheSame(oldItem: Folder, newItem: Folder): Boolean {
        return oldItem.bucketDisplayName == newItem.bucketDisplayName
    }

}