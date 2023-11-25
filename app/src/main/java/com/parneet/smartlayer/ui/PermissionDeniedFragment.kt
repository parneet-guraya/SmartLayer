package com.parneet.smartlayer.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.parneet.smartlayer.R
import com.parneet.smartlayer.databinding.FragmentPermissionDeniedBinding

class PermissionDeniedFragment : Fragment() {
    private var _binding: FragmentPermissionDeniedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPermissionDeniedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.openAppSettings.setOnClickListener { openSettings() }
    }

    override fun onResume() {
        super.onResume()
        checkIfGranted()
    }

    private fun checkIfGranted() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                AppUtils.getReadMediaPermission()
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            findNavController().navigate(R.id.action_permissionDeniedFragment_to_folderListFragment)
        }
    }

    private fun openSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", requireActivity().packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}