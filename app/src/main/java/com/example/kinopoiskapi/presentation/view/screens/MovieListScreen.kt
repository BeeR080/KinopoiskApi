package com.example.kinopoiskapi.presentation.view.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.kinopoiskapi.MovieUiState
import com.example.kinopoiskapi.presentation.viewmodel.MovieViewModel


@Composable
fun MovieListScreen(
    viewModel: MovieViewModel = viewModel()
){
    val movieState by viewModel.uiState.collectAsState()
    MovieList(movieState = movieState)

}

@Composable
fun MovieList(movieState: MovieUiState){
    val list = movieState.data?: emptyList()
    Log.d("MyLogs", movieState.toString())
    LazyColumn{
        items(list){movie->
         MovieItems(
             filmName = movie.name,
             imageUri = movie.backdrop.url,
             imagePreviewUri = movie.logo.url

             )
    }
}



}

@Composable
fun MovieItems(filmName:String, imageUri:String,imagePreviewUri:String){


    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 0.dp, height = 300.dp)
            .padding(
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp,
                top = 8.dp
            )

    ) {
        BoxWithConstraints (
            contentAlignment = Alignment.Center
        ){
            Box{
                AsyncImage(
                    model = imageUri,
                    contentDescription = "Image for films",
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .size(264.dp),



                ) {
                AsyncImage(
                    model = imagePreviewUri,
                    contentDescription = "Image for film's previews",
                    contentScale = ContentScale.Inside,

                )

            }
        }





    }

}


