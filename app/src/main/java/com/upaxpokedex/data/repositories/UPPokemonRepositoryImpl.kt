package com.upaxpokedex.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.upaxpokedex.data.database.UPModuleDatabase
import com.upaxpokedex.data.datasources.UPPokemonPagingSource
import com.upaxpokedex.data.remote.UPApiService
import com.upaxpokedex.data.remote.UPPokemonDetailResponse
import kotlinx.coroutines.flow.Flow

class UPPokemonRepositoryImpl(private val apiService: UPApiService, private val moduleDatabase: UPModuleDatabase) : UPPokemonRepository {

    override fun getPokemonList(): Flow<PagingData<UPPokemonDetailResponse>> =
        Pager(
            config = PagingConfig(
                pageSize = 25,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UPPokemonPagingSource(apiService, moduleDatabase) }
        ).flow
}