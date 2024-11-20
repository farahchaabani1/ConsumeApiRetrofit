package com.example.consumeapiretrofit.data

import com.example.consumeapiretrofit.model.Pokemon
import com.example.consumeapiretrofit.network.PockApi

interface PokemonRepository {
    suspend fun  getAllPokemon():List<Pokemon>
}
class NetworkPokemonRepository:PokemonRepository{
    override suspend fun getAllPokemon(): List<Pokemon> {
        return PockApi.retrofitService.getAllPokemon()
    }

}