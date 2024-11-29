package com.example.consumeapiretrofit.network

import com.example.consumeapiretrofit.model.Pokemon
import com.example.consumeapiretrofit.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon")
    suspend fun  getAllPokemon():List<Pokemon>
}