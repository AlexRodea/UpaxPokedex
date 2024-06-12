package com.upaxpokedex.di

import com.upaxpokedex.ui.pokedex.UPPokedexViewModel

object UPViewModelProvider {
    fun providesPokedexViewModel(): UPPokedexViewModel =
        UPPokedexViewModel(
            UPUseCaseProvider.providesGetPokemonListUseCase()
        )
}