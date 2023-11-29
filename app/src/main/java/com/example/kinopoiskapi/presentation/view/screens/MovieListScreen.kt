package com.example.kinopoiskapi.presentation.view.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.kinopoiskapi.presentation.viewmodel.MovieViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MovieListScreen(
    viewModel:MovieViewModel = viewModel()
){

    val movieState by viewModel.uiState.collectAsState()

    Log.d("MyLogss", movieState.toString())

}