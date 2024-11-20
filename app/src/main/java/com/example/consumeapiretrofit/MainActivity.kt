package com.example.consumeapiretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.consumeapiretrofit.ui.theme.ConsumeApiRetrofitTheme
import com.example.consumeapiretrofit.view.PokApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConsumeApiRetrofitTheme {
                    PokApp()
            }
        }
    }
}

