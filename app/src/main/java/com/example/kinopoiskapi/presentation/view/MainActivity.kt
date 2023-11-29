package com.example.kinopoiskapi.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kinopoiskapi.presentation.theme.KinopoiskApiTheme
import com.example.kinopoiskapi.presentation.view.screens.MovieListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KinopoiskApiTheme {
             MovieListScreen()
            }
        }
    }
}


