package com.upaxpokedex.data.repositories

import androidx.paging.PagingData
import com.upaxpokedex.data.remote.UPPokemonDetailResponse
import kotlinx.coroutines.flow.Flow

interface UPPokemonRepository {
    fun getPokemonList() : Flow<PagingData<UPPokemonDetailResponse>>
}