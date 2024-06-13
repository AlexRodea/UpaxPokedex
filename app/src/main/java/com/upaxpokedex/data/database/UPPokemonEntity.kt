package com.upaxpokedex.data.database

import androidx.annotation.Keep
import androidx.room.Entity

@Keep
@Entity(tableName = "Pokemon", primaryKeys = ["id"])
data class UPPokemonEntity(
    val id: Int,
    val name: String,
    val photo: String,
    val heigh: Int,
    val weight: Int,
    val type: String,
    val isFavorite: Boolean = false
)
