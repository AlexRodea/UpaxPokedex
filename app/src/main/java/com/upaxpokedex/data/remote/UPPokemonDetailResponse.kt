package com.upaxpokedex.data.remote

import com.google.gson.annotations.SerializedName

data class UPPokemonDetailResponse(
    var id: Int,
    var name: String,
    var height: Int,
    var weight: Int,
    var sprites: Sprites,
    var types: List<Types>
)

data class  Sprites(
    @SerializedName("front_default")
    var frontDefault: String
)

data class Types(
    val type: Type
)

data class Type(
    val name: String
)
