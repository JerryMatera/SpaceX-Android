package io.github.jerrymatera.spacex.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import io.github.jerrymatera.spacex.databinding.FragmentHomeBinding
import io.github.jerrymatera.spacex.ui.adapters.SpaceShipAdapter
import io.github.jerrymatera.spacex.ui.viewmodel.HomeViewModel
import io.github.jerrymatera.spacex.utils.Resource
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var spaceShipAdapter: SpaceShipAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)

        binding.recyclerView.adapter = spaceShipAdapter
        homeViewModel.spaceShips.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Failure -> TODO()
                is Resource.Loading -> TODO()
                is Resource.Success -> {
                    response.data.let {
                        spaceShipAdapter.submitList(it)
                    }
                }
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}