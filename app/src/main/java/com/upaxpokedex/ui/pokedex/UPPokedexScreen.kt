package com.upaxpokedex.ui.pokedex

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.upaxpokedex.ui.profile.ProfileShape
import kotlin.math.roundToInt
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.upaxpokedex.R
import com.upaxpokedex.ui.custom.LoadingIndicator
import com.upaxpokedex.ui.custom.shimmerEffect


@Composable
fun PokedexScreen(viewModel: UPPokedexViewModel) {
    val state = viewModel.dataState.collectAsState()
    val pokemonList = state.value.data.collectAsLazyPagingItems()
    var isFirstLoading = false
    var isLoadingPage = false
    var isError = false
    val screenWidth = with(LocalDensity.current) {
        LocalContext.current.resources.displayMetrics.widthPixels / density
    }
    val itemWidth = (screenWidth * 0.4).roundToInt().dp
    pokemonList.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                Log.e("Alex state", "loadState.refresh ")
                isFirstLoading = true
            }

            loadState.append is LoadState.Loading -> {
                Log.e("Alex state", "loadState.append ")
                isLoadingPage = true
            }

            loadState.refresh is LoadState.Error -> {
                isError = true
            }

            loadState.append is LoadState.Error -> {
                isError = true
            }
        }
    }
    LaunchedEffect(key1 = Unit) {
        viewModel.getPokemonList()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (!isFirstLoading) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            {
                items(pokemonList) { pokemon ->
                    Log.e("Alex flow", "items")
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ProfileShape(
                            name = pokemon?.name ?: "",
                            lastname = "",
                            photo = pokemon?.sprites?.frontDefault ?: "",
                            screenWidth = itemWidth,
                            hasPhoto = !pokemon?.sprites?.frontDefault.isNullOrBlank()
                        )
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(
                            text = pokemon?.name ?: "",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                val list = listOf("", "", "", "")
                items(list) {
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(itemWidth)
                                .height(itemWidth)
                                .shimmerEffect(isLoading = true, shape = CircleShape)
                        ) {

                        }
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(
                            text = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .shimmerEffect(isLoading = true, shape = RectangleShape)
                        )
                    }
                }
            }
        }
    }
    if (isLoadingPage) LoadingIndicator()
    if (isError) ShowError()
}

@Composable
fun ShowError(message: String = "Something went wrong") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Error Image",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = message, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Red)
    }
}