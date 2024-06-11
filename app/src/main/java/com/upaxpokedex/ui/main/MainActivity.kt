package com.upaxpokedex.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upaxpokedex.databinding.UpActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding : UpActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*setContent {
            UpaxPokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }

         */
    }
}

