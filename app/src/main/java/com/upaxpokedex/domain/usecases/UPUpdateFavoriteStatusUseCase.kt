package com.upaxpokedex.domain.usecases

import com.upaxpokedex.data.repositories.UPPokemonRepository

class UPUpdateFavoriteStatusUseCase(private val repository: UPPokemonRepository) {
    suspend operator fun invoke(
        id: Int,
        isFavorite: Boolean
    ) = repository.updateFavoriteStatus(id, isFavorite)
}