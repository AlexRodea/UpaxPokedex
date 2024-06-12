package com.upaxpokedex.data.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.upaxpokedex.data.remote.UPApiService
import com.upaxpokedex.data.remote.UPPokemonDetailResponse

class UPPokemonPagingSource(private val apiService: UPApiService) : PagingSource<Int, UPPokemonDetailResponse>() {
    override fun getRefreshKey(state: PagingState<Int, UPPokemonDetailResponse>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UPPokemonDetailResponse> {
        val offset = params.key ?: 0
        val loadSize = params.loadSize
        return try {
            val response = apiService.getPokemonList(loadSize, offset)
            val pokemonList = response.results
            val pokemonListNew = mutableListOf<UPPokemonDetailResponse>()
            pokemonList.forEach {
                pokemonListNew.add(apiService.getPokemonDetail(it.name))
            }
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