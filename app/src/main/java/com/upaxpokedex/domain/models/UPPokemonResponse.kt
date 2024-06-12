package com.upaxpokedex.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UPPokemonResponse(
    val results: List<UPPokemon>,
    val count: Int,
    val next: String?,
    val previous: String
) : Parcelable