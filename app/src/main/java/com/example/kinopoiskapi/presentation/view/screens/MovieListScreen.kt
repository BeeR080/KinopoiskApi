package com.example.kinopoiskapi.presentation.view.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kinopoiskapi.presentation.viewmodel.MovieViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinopoiskapi.MovieUiState


@Composable
fun MovieListScreen(
    viewModel:MovieViewModel = viewModel()
){

    val movieState by viewModel.uiState.collectAsState()
    Log.d("MyLog", "in : ListScreen: ${movieState.data}")





}



@Composable

fun lazyColumns(movieUiState: MovieUiState){


    LazyColumn(
        modifier = Modifier
    ) {

        items(movieUiState.data) {movies->
            Text(text = movies)

        }
    }
}