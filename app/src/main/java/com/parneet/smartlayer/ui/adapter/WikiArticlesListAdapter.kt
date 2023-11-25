package com.parneet.smartlayer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.WikipediaArticlesListBinding
import com.parneet.smartlayer.model.Page

class WikiArticlesListAdapter(
    private val onItemClick: (pageId: Int) -> Unit
) :
    RecyclerView.Adapter<WikiArticlesListAdapter.ListItemViewHolder>() {

    private var articlesList: List<Page> = listOf()

    class ListItemViewHolder(
        binding: WikipediaArticlesListBinding,
        onItemClick: (pageId: Int) -> Unit,
        articlesList: List<Page>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val pageId = articlesList[bindingAdapterPosition].id
                onItemClick(pageId)
            }
        }

        val titleTV = binding.articleTitle
        val descriptionTV = binding.description
        val articleIV = binding.articleImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(
            WikipediaArticlesListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemClick,
            articlesList
        )
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val article = articlesList[position]
        holder.titleTV.text = article.title
        holder.descriptionTV.text = article.description
        holder.articleIV.load(article.thumbnail?.url) {
            crossfade(true)
//            error(R.drawable.baseline_broken_image_24)
            fallback(R.drawable.baseline_broken_image_24)
        }
        // yet to add image functionality using image loading libraries like Koil or Glide

    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    fun submitList(articlesList: List<Page>) {
        this.articlesList = articlesList
    }
}