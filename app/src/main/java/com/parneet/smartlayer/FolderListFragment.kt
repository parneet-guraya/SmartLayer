package com.parneet.smartlayer

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.parneet.smartlayer.databinding.FragmentFolderListBinding
import kotlinx.coroutines.launch

class FolderListFragment : Fragment() {
    private var _binding: FragmentFolderListBinding? = null
    private val binding get() = _binding!!
    private val requestPermissionLauncher = requestPermissionLauncher()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
                getReadMediaPermission()
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            loadVideoFolders()
        } else {
            requestPermissionLauncher.launch(getReadMediaPermission())
        }
    }

    private fun requestPermissionLauncher(): ActivityResultLauncher<String> {
        return registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            println("launch result callback")
            if (isGranted) {
                // show folders
                loadVideoFolders()
            } else {
                Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT)
                    .show()
                findNavController().navigate(R.id.permissionDeniedFragment)
            }
        }
    }

    private fun loadVideoFolders() {
        lifecycleScope.launch {
            val videoFolderList = VideoManager.getVideoFolders(requireActivity().applicationContext)
            val adapter = FolderListAdapter(videoFolderList) { bucketId ->
                goToVideoList(bucketId)
            }

            binding.foldersRecyclerView.layoutManager =
                LinearLayoutManager(requireContext()) // GridLayoutManager(requireContext(), 3)
            binding.foldersRecyclerView.adapter = adapter
        }
    }

    private fun goToVideoList(bucketId: String) {
        val bundle = Bundle().also { bundle -> bundle.putString(EXTRA_BUCKET_ID, bucketId) }
        findNavController().navigate(R.id.action_folderListFragment_to_videoFolderFragment, bundle)
    }

    private fun getReadMediaPermission(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_VIDEO
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_BUCKET_ID = "EXTRA_BUCKET_ID"
    }

}