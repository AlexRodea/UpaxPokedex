package com.upaxpokedex.data.mappers

import com.upaxpokedex.data.database.UPPokemonEntity
import com.upaxpokedex.data.remote.UPPokemonDetailResponse

fun UPPokemonDetailResponse.toEntity() : UPPokemonEntity {
    return UPPokemonEntity(
        this.id,
        this.name,
        this.sprites.frontDefault,
        this.height,
        this.weight,
        this.types[0]?.type?.name ?: "type"
    )
}