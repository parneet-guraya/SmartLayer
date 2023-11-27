package com.parneet.smartlayer.ui.fragments.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.parneet.smartlayer.databinding.WikipediaArticlesDialogFragmentBinding
import com.parneet.smartlayer.ui.util.AppUtils
import com.parneet.smartlayer.ui.viewmodels.WikipediaArticlesDialogViewModel
import kotlinx.coroutines.launch

class WikipediaArticlesDialogFragment(private val onItemClick: (pageId: Int) -> Unit) :
    DialogFragment() {

    private var _binding: WikipediaArticlesDialogFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WikipediaArticlesDialogViewModel by viewModels()

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

        binding.closeDialogButton.setOnClickListener {
            dialog?.dismiss()
        }

        observeState()
        viewModel.initializeAdapter(onItemClick)
        binding.articlesRecyclerView.adapter = viewModel.adapter
        val searchQuery = arguments?.getString(KEY_SEARCH_QUERY)

        if (searchQuery != null) {
            viewModel.loadWikiArticles(searchQuery)
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    AppUtils.toggleLoading(
                        state.isLoading,
                        binding.articlesRecyclerView,
                        binding.progressCircular
                    )
                    when {
                        (state.errorMessage.isNotEmpty()) -> AppUtils.showSnackBar(
                            binding.root,
                            state.errorMessage
                        )

                        (state.isListEmpty) -> AppUtils.showSnackBar(
                            binding.root,
                            "No Articles to show!!"
                        )

                        else -> viewModel.adapter.submitList(state.articlesList)
                    }
                }
            }
        }
    }

    companion object {
        const val KEY_SEARCH_QUERY = "KEY_SEARCH_QUERY"
    }
}