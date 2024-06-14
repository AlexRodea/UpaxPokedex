package com.upaxpokedex.data.repositories

import androidx.paging.PagingData
import com.upaxpokedex.domain.models.UPPokemonDomain
import kotlinx.coroutines.flow.Flow

interface UPPokemonRepository {
    fun getPokemonList() : Flow<PagingData<UPPokemonDomain>>

    suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean)
}