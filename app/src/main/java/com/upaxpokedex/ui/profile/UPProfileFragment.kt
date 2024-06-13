package com.upaxpokedex.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.upaxpokedex.databinding.UpFragmentProfileBinding
import com.upaxpokedex.di.ModuleViewModel
import com.upaxpokedex.di.UPViewModelFactory
import com.upaxpokedex.ui.theme.UpaxPokedexTheme


class UPProfileFragment : Fragment() {
    private lateinit var binding: UpFragmentProfileBinding
    private val viewModel: UPProfileViewModel by viewModels {
        UPViewModelFactory(requireContext(), ModuleViewModel.PROFILE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UpFragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfProfiles = viewModel.getListOfProfiles()
        binding.containerListProfiles.setContent {
            UpaxPokedexTheme {
               ProfileScreen(listOfProfiles = listOfProfiles)
            }
        }
    }
}

