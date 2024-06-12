package com.upaxpokedex.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UPPokemon(val name: String, val sprite: String) : Parcelable