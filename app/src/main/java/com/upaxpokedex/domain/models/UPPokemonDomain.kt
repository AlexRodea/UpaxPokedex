package com.upaxpokedex.domain.models

data class UPPokemonDomain(
    val id: String,
    val name: String,
    val photo: String,
    val height: String,
    val weight: String,
    val type: String,
    val isFavorite: Boolean = false,
)
