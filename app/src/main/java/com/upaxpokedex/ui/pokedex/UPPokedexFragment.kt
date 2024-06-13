package com.upaxpokedex.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.upaxpokedex.databinding.UpFragmentPokedexBinding
import com.upaxpokedex.di.ModuleViewModel
import com.upaxpokedex.di.UPViewModelFactory
import com.upaxpokedex.ui.theme.UpaxPokedexTheme

class UPPokedexFragment : Fragment() {
    private lateinit var binding : UpFragmentPokedexBinding
    private val viewModel : UPPokedexViewModel by viewModels {
        UPViewModelFactory(requireContext(), ModuleViewModel.POKEDEX)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UpFragmentPokedexBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.containerPokedex.setContent {
            UpaxPokedexTheme {
                PokedexScreen(viewModel)
            }
        }
    }
}