package com.upaxpokedex.data.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.upaxpokedex.data.remote.UPApiService
import com.upaxpokedex.domain.models.UPPokemon

class UPPokemonPagingSource(private val apiService: UPApiService) : PagingSource<Int, UPPokemon>() {
    override fun getRefreshKey(state: PagingState<Int, UPPokemon>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UPPokemon> {
        val offset = params.key ?: 0
        val loadSize = params.loadSize
        return try {
            val response = apiService.getPokemonList(loadSize, offset)
            val pokemonList = response.results
            LoadResult.Page(
                data = pokemonList,
                prevKey = if (offset == 0) null else offset - loadSize,
                nextKey = if (response.next == null) null else offset + loadSize
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}