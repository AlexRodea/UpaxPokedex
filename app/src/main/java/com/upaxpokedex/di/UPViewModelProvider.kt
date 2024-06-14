package com.upaxpokedex.di

import android.content.Context
import com.upaxpokedex.ui.pokedex.UPPokedexViewModel

object UPViewModelProvider {
    fun providesPokedexViewModel(context: Context): UPPokedexViewModel =
        UPPokedexViewModel(
            UPUseCaseProvider.providesGetPokemonListUseCase(context),
            UPUseCaseProvider.providesUpdateFavoriteStatusUseCase(context)
        )
}