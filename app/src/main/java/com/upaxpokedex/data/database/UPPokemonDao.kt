package com.upaxpokedex.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UPPokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: UPPokemonEntity)

    @Query("SELECT name FROM pokemon WHERE name = :name")
    suspend fun findPokemonByName(name: String) : String?

    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemons(): List<UPPokemonEntity>

    @Query("SELECT * FROM pokemon ORDER BY id LIMIT :limit OFFSET :offset")
    suspend fun getLastAddedPokemons(limit: Int, offset: Int) : List<UPPokemonEntity>

    @Query("UPDATE pokemon SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean)
}