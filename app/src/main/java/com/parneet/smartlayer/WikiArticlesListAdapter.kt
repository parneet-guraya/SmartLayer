package com.parneet.smartlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.parneet.smartlayer.databinding.WikipediaArticlesListBinding
import com.parneet.smartlayer.model.Page

class WikiArticlesListAdapter(
    private val articlesList: List<Page>,
    private val wikiArticleClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<WikiArticlesListAdapter.ListItemViewHolder>() {

    class ListItemViewHolder(
        binding: WikipediaArticlesListBinding,
        wikiArticleClickListener: OnItemClickListener,
        articlesList: List<Page>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val pageId = articlesList[bindingAdapterPosition].id
                wikiArticleClickListener.onItemClick(pageId)
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
            wikiArticleClickListener,
            articlesList
        )
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val article = articlesList[position]
        holder.titleTV.text = article.title
        holder.descriptionTV.text = article.description
        holder.articleIV.load(article.thumbnail?.url)
        // yet to add image functionality using image loading libraries like Koil or Glide

    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    interface OnItemClickListener {
        fun onItemClick(pageId: Int) {

        }
    }
}