package com.upaxpokedex.data.mappers

import com.upaxpokedex.data.database.UPPokemonEntity
import com.upaxpokedex.data.remote.UPPokemonDetailResponse
import com.upaxpokedex.domain.models.UPPokemonDomain

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

fun UPPokemonEntity.toDomain(): UPPokemonDomain {
    return UPPokemonDomain(
        this.id.toString(),
        this.name,
        this.photo,
        this.heigh.toString(),
        this.weight.toString(),
        this.type,
        this.isFavorite
    )
}

fun List<UPPokemonEntity>.toDomain(): List<UPPokemonDomain> {
    return this.map {
        UPPokemonDomain(
            id = it.id.toString(),
            name = it.name,
            photo = it.photo,
            weight = it.weight.toString(),
            height = it.heigh.toString(),
            type = it.type,
            isFavorite = it.isFavorite
        )
    }
}