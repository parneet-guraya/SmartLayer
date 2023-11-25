package com.parneet.smartlayer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.parneet.smartlayer.RetrofitClient
import com.parneet.smartlayer.databinding.WikipediaArticlesDialogFragmentBinding
import com.parneet.smartlayer.model.service.WikipediaApi
import kotlinx.coroutines.launch

class WikipediaArticlesDialogFragment(private val wikiArticleItemClickListener: WikiArticlesListAdapter.OnItemClickListener) :
    DialogFragment() {

    private var _binding: WikipediaArticlesDialogFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WikipediaArticlesDialogFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val window = dialog?.window
        val params = window?.attributes

        params?.let { parameters ->
            parameters.width = ViewGroup.LayoutParams.MATCH_PARENT
        }

        window?.attributes = params

        val wikipediaApi = RetrofitClient.retrofit.create(WikipediaApi::class.java)

        lifecycleScope.launch {
            AppUtils.toggleLoading(
                true,
                binding.articlesRecyclerView,
                binding.progressCircular,
                true
            )
            val searchQuery = arguments?.getString(KEY_SEARCH_QUERY)
            val list = wikipediaApi.fetchArticles(searchQuery!!).pages
            val articlesAdapter = WikiArticlesListAdapter(list, wikiArticleItemClickListener)
            binding.articlesRecyclerView.adapter = articlesAdapter
            AppUtils.toggleLoading(
                false,
                binding.articlesRecyclerView,
                binding.progressCircular
            )
            println(list)
        }
    }

    companion object {
        const val KEY_SEARCH_QUERY = "KEY_SEARCH_QUERY"
    }
}