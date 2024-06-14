package com.upaxpokedex.di

import android.content.Context
import com.upaxpokedex.domain.usecases.UPGetPokemonListUseCase
import com.upaxpokedex.domain.usecases.UPUpdateFavoriteStatusUseCase

object UPUseCaseProvider {
    fun providesGetPokemonListUseCase(context: Context): UPGetPokemonListUseCase =
        UPGetPokemonListUseCase(UPRepositoryProvider.providesPokemonRepository(context))

    fun providesUpdateFavoriteStatusUseCase(context: Context): UPUpdateFavoriteStatusUseCase =
        UPUpdateFavoriteStatusUseCase(UPRepositoryProvider.providesPokemonRepository(context))
}