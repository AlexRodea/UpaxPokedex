package com.upaxpokedex.di

import com.upaxpokedex.domain.usecases.UPGetPokemonListUseCase

object UPUseCaseProvider {
    fun providesGetPokemonListUseCase(): UPGetPokemonListUseCase =
        UPGetPokemonListUseCase(UPRepositoryProvider.providesPokemonRepository())
}