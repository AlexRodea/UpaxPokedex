package com.upaxpokedex.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UPListPokemonResponse(
    val results: List<UPPokemonResponse>,
    val count: Int,
    val next: String?,
    val previous: String
) : Parcelable