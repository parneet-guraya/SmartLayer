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
import com.parneet.smartlayer.ui.util.AppUtils
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
                AppUtils.getReadMediaPermission()
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            initializeRecyclerView()
            observeState()
            viewModel.loadVideoFolders()
        } else {
            requestPermissionLauncher.launch(AppUtils.getReadMediaPermission())
        }
    }

    private fun initializeRecyclerView() {
        viewModel.initializeListAdapter { bucketId -> goToVideoList(bucketId) }
        binding.foldersRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        binding.foldersRecyclerView.adapter = viewModel.adapter
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    AppUtils.toggleLoading(
                        state.isLoading,
                        binding.foldersRecyclerView,
                        binding.progressCircular
                    )
                    when {
                        (state.errorMessage.isNotEmpty()) -> AppUtils.showSnackBar(
                            binding.root,
                            state.errorMessage
                        )

                        (state.isListEmpty) -> AppUtils.showSnackBar(
                            binding.root,
                            "No Video Folders are present!"
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
                viewModel.loadVideoFolders()
            } else {
                Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT)
                    .show()
                findNavController().navigate(R.id.permissionDeniedFragment)
            }
        }
    }

    private fun goToVideoList(bucketId: String) {
        val bundle = Bundle().also { bundle -> bundle.putString(EXTRA_BUCKET_ID, bucketId) }
        findNavController().navigate(R.id.action_folderListFragment_to_videoFolderFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_BUCKET_ID = "EXTRA_BUCKET_ID"
    }

}