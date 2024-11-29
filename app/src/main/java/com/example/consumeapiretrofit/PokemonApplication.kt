package com.example.consumeapiretrofit

import android.app.Application
import com.example.consumeapiretrofit.data.AppContainer
import com.example.consumeapiretrofit.data.DefaultAppContainer

class PokemonApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}