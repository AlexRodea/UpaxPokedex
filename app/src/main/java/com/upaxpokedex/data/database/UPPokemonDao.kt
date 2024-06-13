package com.upaxpokedex.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UPPokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: UPPokemonEntity)

    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemons(): List<UPPokemonEntity>
}