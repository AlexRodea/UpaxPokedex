package com.upaxpokedex.di

import android.content.Context
import com.upaxpokedex.data.repositories.UPPokemonRepository
import com.upaxpokedex.data.repositories.UPPokemonRepositoryImpl

object UPRepositoryProvider {
    fun providesPokemonRepository(context: Context) : UPPokemonRepository =
        UPPokemonRepositoryImpl(
            UPDataProvider.providesApiService(),
            UPDatabaseBuilder.providesDatabase(context)
        )
}