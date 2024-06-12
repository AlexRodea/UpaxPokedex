package com.upaxpokedex.ui.pokedex

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.upaxpokedex.ui.profile.ProfileShape
import kotlin.math.roundToInt
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items


@Composable
fun PokedexScreen(viewModel: UPPokedexViewModel) {
    val state = viewModel.dataState.collectAsState()
    val pokemonList = state.value.data.collectAsLazyPagingItems()
    pokemonList.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                // Muestra un indicador de carga inicial
                //item { LoadingIndicator() }
            }

            loadState.append is LoadState.Loading -> {
                // Muestra un indicador de carga para la paginación
                //item { LoadingIndicator() }
            }

            loadState.refresh is LoadState.Error -> {
                // Manejar el error de carga inicial
                // val e = pagingItems.loadState.refresh as LoadState.Error
                //item { ErrorItem(message = e.error.localizedMessage) }
            }

            loadState.append is LoadState.Error -> {
                // Manejar el error de carga paginada
                //val e = pagingItems.loadState.append as LoadState.Error
                //item { ErrorItem(message = e.error.localizedMessage) }
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
        val screenWidth = with(LocalDensity.current) {
            LocalContext.current.resources.displayMetrics.widthPixels / density
        }
        val itemWidth = (screenWidth * 0.4).roundToInt().dp
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)){
            items(pokemonList) { pokemon ->
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
    }
}