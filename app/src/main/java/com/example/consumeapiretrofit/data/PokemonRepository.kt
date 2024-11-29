package com.example.consumeapiretrofit.data

import com.example.consumeapiretrofit.model.Pokemon
import com.example.consumeapiretrofit.network.ApiService

interface PokemonRepository {
    suspend fun  getAllPokemon():List<Pokemon>
}

class NetworkPokemonRepository(private val pokemonApiService: ApiService
):PokemonRepository{
    override suspend fun getAllPokemon(): List<Pokemon> {
        return pokemonApiService.getAllPokemon()
    }

}