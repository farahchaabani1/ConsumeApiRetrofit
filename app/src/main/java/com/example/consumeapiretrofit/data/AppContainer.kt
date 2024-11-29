package com.example.consumeapiretrofit.data

import com.example.consumeapiretrofit.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppContainer {
    val pokemonRepository:PokemonRepository

}

class DefaultAppContainer : AppContainer {

    private val BASE_URL = "https://tyradex.vercel.app/api/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create()) // For JSON parsing
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val pokemonRepository: PokemonRepository by lazy {
        NetworkPokemonRepository(retrofitService)
    }

}