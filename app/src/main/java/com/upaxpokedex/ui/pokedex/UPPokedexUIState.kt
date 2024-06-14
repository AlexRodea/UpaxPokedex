package com.upaxpokedex.ui.pokedex

import androidx.paging.PagingData
import com.upaxpokedex.data.remote.UPPokemonDetailResponse
import com.upaxpokedex.domain.models.UPPokemonDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class UPPokedexUIState(
    val data: Flow<PagingData<UPPokemonDomain>> = flowOf(PagingData.empty()),
)