package com.upaxpokedex.ui.pokedex

import androidx.paging.PagingData
import com.upaxpokedex.domain.models.UPPokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class UPPokedexUIState(
    val data: Flow<PagingData<UPPokemon>> = flowOf(PagingData.empty()),
)