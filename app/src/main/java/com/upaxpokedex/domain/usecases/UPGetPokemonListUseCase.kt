package com.upaxpokedex.domain.usecases

import com.upaxpokedex.data.repositories.UPPokemonRepository

class UPGetPokemonListUseCase(private val repository: UPPokemonRepository) {
    operator fun invoke() = repository.getPokemonList()

}