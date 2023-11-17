package com.parneet.smartlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.parneet.smartlayer.databinding.FolderItemBinding
import com.parneet.smartlayer.model.Folder

class FolderListAdapter(
    private val foldersList: List<Folder>,
    private val onItemClick: (bucketId: String) -> Unit
) :
    RecyclerView.Adapter<FolderListAdapter.FolderItemViewHolder>() {

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
            foldersList,
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: FolderItemViewHolder, position: Int) {
        val folder = foldersList[position]
        holder.folderNameTV.text = folder.bucketDisplayName
    }

    override fun getItemCount(): Int {
        return foldersList.size
    }
}