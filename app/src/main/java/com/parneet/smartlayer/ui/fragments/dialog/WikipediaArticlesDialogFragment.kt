package com.parneet.smartlayer.ui.fragments.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.parneet.smartlayer.data.wikiarticles.WikiArticlesRepository
import com.parneet.smartlayer.databinding.WikipediaArticlesDialogFragmentBinding
import com.parneet.smartlayer.common.Response
import com.parneet.smartlayer.ui.activities.logDebug
import com.parneet.smartlayer.ui.adapter.WikiArticlesListAdapter
import com.parneet.smartlayer.ui.util.AppUtils
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WikipediaArticlesDialogFragment(private val onItemClick: (pageId: Int) -> Unit) :
    DialogFragment() {

    private var _binding: WikipediaArticlesDialogFragmentBinding? = null
    private val binding get() = _binding!!
    private val wikiArticlesRepository = WikiArticlesRepository()
    private lateinit var adapter: WikiArticlesListAdapter

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
        isCancelable = false
        val window = dialog?.window
        val params = window?.attributes

        params?.let { parameters ->
            parameters.width = ViewGroup.LayoutParams.MATCH_PARENT
        }

        window?.attributes = params

        binding.closeDialogButton.setOnClickListener {
            dialog?.dismiss()
        }

        adapter = WikiArticlesListAdapter(onItemClick = onItemClick)
        binding.articlesRecyclerView.adapter = adapter

        lifecycleScope.launch {
            val searchQuery = arguments?.getString(KEY_SEARCH_QUERY)

            val wikiArticlesRequestResponse = wikiArticlesRepository.fetchArticles(searchQuery!!)
            wikiArticlesRequestResponse.collectLatest { response ->
                println(response)
                when (response) {
                    is Response.Error -> logDebug(response.exception?.message!!)
                    is Response.Loading -> AppUtils.toggleLoading(
                        response.isLoading,
                        binding.articlesRecyclerView,
                        binding.progressCircular
                    )

                    is Response.Success -> {
                        val list = response.data?.pages
                        println("wiki response : $list")
                        if (!list.isNullOrEmpty()) {
                            adapter.submitList(list)
                        } else {
                            println("wiki articles list empty")
                            //revisit: show message that list is empty
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val KEY_SEARCH_QUERY = "KEY_SEARCH_QUERY"
    }
}