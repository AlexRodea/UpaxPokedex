package com.upaxpokedex.di

import android.content.Context
import com.upaxpokedex.domain.usecases.UPGetPokemonListUseCase

object UPUseCaseProvider {
    fun providesGetPokemonListUseCase(context: Context): UPGetPokemonListUseCase =
        UPGetPokemonListUseCase(UPRepositoryProvider.providesPokemonRepository(context))
}