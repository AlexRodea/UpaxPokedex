package com.upaxpokedex.domain.usecases

import androidx.paging.PagingData
import com.upaxpokedex.data.repositories.UPPokemonRepository
import com.upaxpokedex.domain.models.UPPokemonDomain
import kotlinx.coroutines.flow.Flow

class UPGetPokemonListUseCase(private val repository: UPPokemonRepository) {
    operator fun invoke(): Flow<PagingData<UPPokemonDomain>> {
      return repository.getPokemonList()
    }

}