package com.upaxpokedex.data.datasources

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.upaxpokedex.data.database.UPModuleDatabase
import com.upaxpokedex.data.mappers.toDomain
import com.upaxpokedex.data.mappers.toEntity
import com.upaxpokedex.data.remote.UPApiService
import com.upaxpokedex.domain.models.UPPokemonDomain

class UPPokemonPagingSource(
    private val apiService: UPApiService,
    private val moduleDatabase: UPModuleDatabase
) : PagingSource<Int, UPPokemonDomain>() {
    override fun getRefreshKey(state: PagingState<Int, UPPokemonDomain>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UPPokemonDomain> {
        val offset = params.key ?: 0
        val loadSize = params.loadSize
        return try {
            Log.e("Alex fav", "loadsize = $loadSize || offset = $offset")
            val response = apiService.getPokemonList(loadSize, offset)
            Log.e("Alex fav", "results = ${response.results}")
            val pokemonList = response.results
            var pokemonListNew = mutableListOf<UPPokemonDomain>()
            pokemonList.forEach {
                if (moduleDatabase.pokemonDao().findPokemonByName(it.name).isNullOrBlank()) {
                    val pokemonDetail = apiService.getPokemonDetail(it.name)
                    val pokemonEntity = pokemonDetail.toEntity()
                    moduleDatabase.pokemonDao().insertPokemon(pokemonEntity)
                }
            }
            pokemonListNew = moduleDatabase.pokemonDao().getLastAddedPokemons(loadSize, offset).toDomain().toMutableList()
            Log.e("Alex", "pokemonListNew = $pokemonListNew")
            LoadResult.Page(
                data = pokemonListNew,
                prevKey = if (offset == 0) null else offset - loadSize,
                nextKey = if (response.next == null) null else offset + loadSize
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}