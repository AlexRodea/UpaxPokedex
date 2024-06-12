package com.upaxpokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.upaxpokedex.domain.usecases.UPGetPokemonListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UPPokedexViewModel(private val getPokemonListUseCase: UPGetPokemonListUseCase) : ViewModel() {
    private val _dataState = MutableStateFlow(UPPokedexUIState())
    val dataState: StateFlow<UPPokedexUIState> get() = _dataState.asStateFlow()
    fun getPokemonList(){
        _dataState.value = dataState.value.copy(getPokemonListUseCase().cachedIn(viewModelScope))
    }
}