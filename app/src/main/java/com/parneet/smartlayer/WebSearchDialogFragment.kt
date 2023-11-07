package com.parneet.smartlayer

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.addCallback
import androidx.core.view.marginStart
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.parneet.smartlayer.databinding.WebViewLayoutBinding


class WebSearchDialogFragment : DialogFragment() {
    private var _binding: WebViewLayoutBinding? = null
    private val binding get() = _binding!!

    // Revisit: Also onCreateView and OnCreateDialog both should not be overridden at the same time see about that because
    //  tried getting rid of createView and using setContentView of dialog in createDialog, does not work.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WebViewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Revisit change the deprecated use of backpress
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = object: Dialog(requireContext(),theme){
            override fun onBackPressed() {
                if(binding.webView.canGoBack()){
                    binding.webView.goBack()
                }else{
                    super.onBackPressed()
                }
            }
        }
        return dialog
    }

    // Revisit: Why need to define width to the window instead of the fragment layout?
    //  also applying width to the layout does not take effect
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            logDebug("backpressdispatcher")
            if (binding.webView.canGoBack()) {
                logDebug("go back")
                binding.webView.goBack()
            }
        }

        val webView = binding.webView

        val window = dialog?.window
        val params = window?.attributes

        val margin = convertPixelsToDp(8)
        binding.root.updateLayoutParams<MarginLayoutParams> { marginStart = margin
            marginEnd = margin
            topMargin = margin
            bottomMargin = margin}

        params?.let { parameters ->
            parameters.width = ViewGroup.LayoutParams.MATCH_PARENT

        }
        window?.attributes = params


        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }
        webView.loadUrl("https://www.google.com/search?q=${arguments?.getString(
            KEY_WEB_SEARCH_STRING)}")

        binding.navigateBackButton.setOnClickListener {
            if(webView.canGoBack()){
                webView.goBack()
            }else{
                Snackbar.make(it,"At the home page, can't go back!", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
        binding.closeDialogButton.setOnClickListener { dialog?.dismiss() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun convertPixelsToDp(pixels: Int):Int{
        val density = requireContext().resources.displayMetrics.density
        return pixels * density.toInt()
    }

    companion object{
        const val KEY_WEB_SEARCH_STRING = "KEY_WEB_SEARCH_STRING"
    }
}