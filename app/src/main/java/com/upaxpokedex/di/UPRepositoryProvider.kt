package com.upaxpokedex.di

import com.upaxpokedex.data.repositories.UPPokemonRepository
import com.upaxpokedex.data.repositories.UPPokemonRepositoryImpl

object UPRepositoryProvider {
    fun providesPokemonRepository() : UPPokemonRepository =
        UPPokemonRepositoryImpl(UPDataProvider.providesApiService())
}