package com.example.consumeapiretrofit.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumeapiretrofit.model.Pokemon
import com.example.consumeapiretrofit.network.PockApi
import kotlinx.coroutines.launch

import retrofit2.HttpException
import java.io.IOException


sealed interface PockUiState {
    data class Success(val pokemons: List<Pokemon>) : PockUiState
    object Error : PockUiState
    object Loading : PockUiState
}

class PokViewModel: ViewModel() {
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
                val listResult = PockApi.retrofitService.getAllPokemon()
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
}