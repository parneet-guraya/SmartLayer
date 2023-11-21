package com.parneet.smartlayer

import android.Manifest
import android.app.AlertDialog
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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.parneet.smartlayer.databinding.FragmentFolderListBinding
import kotlinx.coroutines.launch

class FolderListFragment : Fragment() {
    private var _binding: FragmentFolderListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFolderListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermissionIfNeeded()
    }

    private fun requestPermissionIfNeeded() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_MEDIA_VIDEO
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            loadVideoFolders()
        } else {
            requestPermissionLauncher().launch(Manifest.permission.READ_MEDIA_VIDEO)
        }
    }

    private fun requestPermissionLauncher(): ActivityResultLauncher<String> {
        return registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // show folders
                loadVideoFolders()
            } else {
                AlertDialog.Builder(requireContext())
                    .setCancelable(false)
                    .setTitle("Need Permission!")
                    .setMessage("Need permission to read media from the phone to display content here.")
                    .setPositiveButton("Ok") { _, _ ->
                        requestPermissionLauncher().launch(Manifest.permission.READ_MEDIA_VIDEO)
                    }.setNegativeButton("Cancel") { _, _ ->
                        requireActivity().finish()
                    }
                    .show()
                Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT)
                    .show()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_BUCKET_ID = "EXTRA_BUCKET_ID"
    }

}