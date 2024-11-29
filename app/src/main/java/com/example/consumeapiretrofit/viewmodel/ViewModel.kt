package com.example.consumeapiretrofit.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumeapiretrofit.PokemonApplication
import com.example.consumeapiretrofit.data.NetworkPokemonRepository
import com.example.consumeapiretrofit.data.PokemonRepository
import com.example.consumeapiretrofit.model.Pokemon
import kotlinx.coroutines.launch

import retrofit2.HttpException
import java.io.IOException


sealed interface PockUiState {
    data class Success(val pokemons: List<Pokemon>) : PockUiState
    object Error : PockUiState
    object Loading : PockUiState
}

class PokViewModel(private val pokemonRepository: PokemonRepository): ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var pockUiState: PockUiState by mutableStateOf(PockUiState.Loading)
        private set

    /**
     */
    init {
        getAllPock()
    }
    fun getAllPock() {
        viewModelScope.launch {

            pockUiState = try {

                val listResult = pokemonRepository.getAllPokemon()

                PockUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                PockUiState.Error
            } catch (e: HttpException) {
                PockUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                PokViewModel(pokemonRepository = pokemonRepository)
            }
        }
    }
}