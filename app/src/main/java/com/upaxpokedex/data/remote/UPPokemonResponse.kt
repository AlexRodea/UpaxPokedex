package com.upaxpokedex.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UPPokemonResponse(val name: String, val url: String) : Parcelable