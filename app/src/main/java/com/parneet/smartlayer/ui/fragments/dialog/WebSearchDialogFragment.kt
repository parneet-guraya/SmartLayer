package com.parneet.smartlayer.ui.fragments.dialog

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.addCallback
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.DialogFragment
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.WebViewLayoutBinding
import com.parneet.smartlayer.ui.util.UIUtils


class WebSearchDialogFragment : DialogFragment() {
    private var _binding: WebViewLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WebViewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = object : Dialog(requireContext(), theme) {
            override fun onBackPressed() {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                } else {
                    super.onBackPressed()
                }
            }
        }
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
            }
        }

        val webView = binding.webView

        val window = dialog?.window
        val params = window?.attributes

        val margin = UIUtils.dpToPixels(8, requireContext().applicationContext)
        binding.root.updateLayoutParams<MarginLayoutParams> {
            marginStart = margin
            marginEnd = margin
            topMargin = margin
            bottomMargin = margin
        }

        params?.let { parameters ->
            parameters.width = ViewGroup.LayoutParams.MATCH_PARENT

        }
        window?.attributes = params


        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                binding.progressCircular.progress = newProgress
            }
        }
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                UIUtils.toggleLoading(
                    true,
                    null,
                    binding.progressCircular,
                    true
                )
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                UIUtils.toggleLoading(
                    false,
                    null,
                    binding.progressCircular,
                    true
                )
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }
        getLoadUrl()?.let {
            webView.loadUrl(it)
        }


        binding.navigateBackButton.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                UIUtils.showSnackBar(binding.root, getString(R.string.web_dialog_cannot_go_back))
            }
        }
        binding.closeDialogButton.setOnClickListener { dialog?.dismiss() }
    }

    private fun getLoadUrl(): String? {
        val data = arguments?.getString(KEY_URL_EXTRA_DATA_STRING)
        val operation = arguments?.getInt(KEY_WEB_OPERATION)
        return when (operation) {
            GOOGLE_SEARCH -> "$GOOGLE_BASE_URL$data"
            WIKI_ARTICLE_PAGE -> "$WIKI_ARTICLE_PAGE_BASE_URL$data"
            else -> {
                null
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        const val KEY_URL_EXTRA_DATA_STRING = "KEY_URL_EXTRA_DATA_STRING"
        const val KEY_WEB_OPERATION = "KEY_WEB_OPERATION"
        private const val GOOGLE_BASE_URL = "https://www.google.com/search?q="
        private const val WIKI_ARTICLE_PAGE_BASE_URL = "https://en.wikipedia.org/?curid="
        const val GOOGLE_SEARCH = 1
        const val WIKI_ARTICLE_PAGE = 2
    }
}