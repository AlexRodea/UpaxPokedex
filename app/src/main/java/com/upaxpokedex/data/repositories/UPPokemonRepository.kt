package com.upaxpokedex.data.repositories

import androidx.paging.PagingData
import com.upaxpokedex.domain.models.UPPokemon
import kotlinx.coroutines.flow.Flow

interface UPPokemonRepository {
    fun getPokemonList() : Flow<PagingData<UPPokemon>>
}