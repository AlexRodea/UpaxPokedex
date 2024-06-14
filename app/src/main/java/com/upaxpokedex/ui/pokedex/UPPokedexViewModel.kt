package com.upaxpokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.upaxpokedex.domain.usecases.UPGetPokemonListUseCase
import com.upaxpokedex.domain.usecases.UPUpdateFavoriteStatusUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UPPokedexViewModel(
    private val getPokemonListUseCase: UPGetPokemonListUseCase,
    private val updateFavoriteStatusUseCase: UPUpdateFavoriteStatusUseCase
) : ViewModel() {
    private val _dataState = MutableStateFlow(UPPokedexUIState())
    val dataState: StateFlow<UPPokedexUIState> get() = _dataState.asStateFlow()
    fun getPokemonList() {
        _dataState.value = dataState.value.copy(getPokemonListUseCase().cachedIn(viewModelScope))
    }

    fun updateFavoriteStatus(id: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            updateFavoriteStatusUseCase.invoke(id, isFavorite)
        }
    }
}