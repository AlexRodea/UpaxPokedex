package com.upaxpokedex.data.remote

import com.upaxpokedex.domain.models.UPPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface UPApiService {
    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): UPPokemonResponse
}