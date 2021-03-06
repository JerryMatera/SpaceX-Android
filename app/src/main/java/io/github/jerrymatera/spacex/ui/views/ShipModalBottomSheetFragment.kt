package io.github.jerrymatera.spacex.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.github.jerrymatera.spacex.R
import io.github.jerrymatera.spacex.databinding.FragmentShipModalBottomSheetBinding

class ShipModalBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentShipModalBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShipModalBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}