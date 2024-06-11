package com.upaxpokedex.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upaxpokedex.R
import com.upaxpokedex.databinding.UpFragmentMainBinding
import com.upaxpokedex.ui.theme.UpaxPokedexTheme

class UPMainFragment : Fragment() {
    private lateinit var binding: UpFragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UpFragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainComposeContainer.setContent {
            UpaxPokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }

    @Composable
    fun Greeting(modifier: Modifier = Modifier) {
        Column(
            modifier =
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello! Select an option",
                modifier = modifier
            )
            Button(
                onClick = {
                    findNavController().navigate(R.id.action_main_to_profile)
                },
            ) {
                Text(text = "Nav Profile")
            }
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Nav Pokedex")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        UpaxPokedexTheme {
            Greeting()
        }
    }
}