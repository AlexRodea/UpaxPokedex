package com.upaxpokedex.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface UPApiService {
    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): UPListPokemonResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): UPPokemonDetailResponse
}