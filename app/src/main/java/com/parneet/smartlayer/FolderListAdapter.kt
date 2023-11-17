package com.parneet.smartlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.parneet.smartlayer.databinding.FolderItemBinding
import com.parneet.smartlayer.model.Folder

class FolderListAdapter(private val foldersList: List<Folder>) :
    RecyclerView.Adapter<FolderListAdapter.FolderItemViewHolder>() {

    class FolderItemViewHolder(binding: FolderItemBinding) : ViewHolder(binding.root) {
        val folderNameTV = binding.folderTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderItemViewHolder {
        return FolderItemViewHolder(
            FolderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
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