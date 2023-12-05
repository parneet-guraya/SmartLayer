package com.parneet.smartlayer.ui.fragments

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.FragmentFolderListBinding
import com.parneet.smartlayer.ui.util.UIUtils
import com.parneet.smartlayer.ui.viewmodels.FolderListFragmentViewModel
import kotlinx.coroutines.launch

class FolderListFragment : Fragment() {
    private var _binding: FragmentFolderListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FolderListFragmentViewModel by viewModels()
    private val requestPermissionLauncher = requestPermissionLauncher()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFolderListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("onViewCreated called")
        requestPermissionIfNeeded()
    }

    private fun requestPermissionIfNeeded() {
        println("requestPermissionIfNeeded called")
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                UIUtils.getReadMediaPermission()
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            initializeRecyclerView()
            observeState()
            viewModel.loadVideoFolders()
        } else {
            requestPermissionLauncher.launch(UIUtils.getReadMediaPermission())
        }
    }

    private fun initializeRecyclerView() {
        viewModel.initializeListAdapter { bucketId, bucketDisplayName ->
            goToVideoList(
                bucketId,
                bucketDisplayName
            )
        }
        binding.foldersRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        binding.foldersRecyclerView.adapter = viewModel.adapter
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    println("folder state")
                    UIUtils.toggleLoading(
                        state.isLoading,
                        binding.foldersRecyclerView,
                        binding.progressCircular
                    )
                    when {
                        (state.errorMessage.isNotEmpty()) -> UIUtils.showSnackBar(
                            binding.root,
                            state.errorMessage
                        )

                        (state.isListEmpty) -> UIUtils.showSnackBar(
                            binding.root,
                            getString(R.string.no_video_folders)
                        )

                        else -> viewModel.adapter.submitList(state.folderList)
                    }
                }
            }
        }
    }

    private fun requestPermissionLauncher(): ActivityResultLauncher<String> {
        return registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            println("launch result callback")
            if (isGranted) {
                // show folders
                initializeRecyclerView()
                observeState()
                viewModel.loadVideoFolders()
            } else {
                UIUtils.showToast(
                    requireContext().applicationContext,
                    getString(R.string.permission_denied),
                    Toast.LENGTH_SHORT
                )
                findNavController().navigate(R.id.permissionDeniedFragment)
            }
        }
    }

    private fun goToVideoList(bucketId: String, bucketDisplayName: String) {
        val bundle = Bundle().also { bundle ->
            bundle.putString(EXTRA_BUCKET_ID, bucketId)
            bundle.putString(EXTRA_BUCKET_DISPLAY_NAME, bucketDisplayName)
        }
        findNavController().navigate(R.id.action_folderListFragment_to_videoFolderFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_BUCKET_ID = "EXTRA_BUCKET_ID"
        const val EXTRA_BUCKET_DISPLAY_NAME = "EXTRA_BUCKET_DISPLAY_NAME"
    }

}