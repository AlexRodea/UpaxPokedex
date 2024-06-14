package com.upaxpokedex.data.repositories

import androidx.paging.PagingData
import com.upaxpokedex.data.remote.UPPokemonDetailResponse
import com.upaxpokedex.domain.models.UPPokemonDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface UPPokemonRepository {
    fun getPokemonList() : Flow<PagingData<UPPokemonDomain>>

    suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean)
}