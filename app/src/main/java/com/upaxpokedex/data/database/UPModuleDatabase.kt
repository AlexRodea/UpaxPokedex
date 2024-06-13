package com.upaxpokedex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UPPokemonEntity::class], version = 1)
abstract class UPModuleDatabase : RoomDatabase() {
    abstract fun pokemonDao() : UPPokemonDao
}