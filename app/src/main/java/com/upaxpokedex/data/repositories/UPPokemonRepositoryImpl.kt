package com.upaxpokedex.data.repositories

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.upaxpokedex.data.database.UPModuleDatabase
import com.upaxpokedex.data.datasources.UPPokemonPagingSource
import com.upaxpokedex.data.remote.UPApiService
import com.upaxpokedex.data.remote.UPPokemonDetailResponse
import com.upaxpokedex.domain.models.UPPokemonDomain
import kotlinx.coroutines.flow.Flow

class UPPokemonRepositoryImpl(private val apiService: UPApiService, private val moduleDatabase: UPModuleDatabase) : UPPokemonRepository {

    override fun getPokemonList(): Flow<PagingData<UPPokemonDomain>> =
        Pager(
            config = PagingConfig(
                pageSize = 25,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UPPokemonPagingSource(apiService, moduleDatabase) }
        ).flow

    override suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean) {
        Log.e("Alex favorite2", "isFavorite -> $isFavorite")
        moduleDatabase.pokemonDao().updateFavoriteStatus(id, isFavorite)
    }
}