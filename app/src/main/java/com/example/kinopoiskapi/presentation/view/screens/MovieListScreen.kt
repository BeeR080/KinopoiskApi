package com.example.kinopoiskapi.presentation.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

import coil.compose.AsyncImage
import com.example.kinopoiskapi.domain.model.Movie

import com.example.kinopoiskapi.presentation.viewmodel.MovieViewModel


@Composable
fun MovieListScreen(
    viewModel: MovieViewModel = viewModel()
){
    val data = viewModel.getMovies().collectAsLazyPagingItems()

    MovieList(data = data)

}

@Composable
fun MovieList(data: LazyPagingItems<Movie>){
    LazyColumn{
        items(data) { movieData ->
            movieData?.let { movie ->
                movie.docs.map { movieItems ->
                    MovieItems(
                        filmName = movieItems.name,
                        imageUri = movieItems.backdrop.url,
                        imagePreviewUri = movieItems.logo?.url ?: ""
                    )
                }

            }

        }
        item {
            when(val data = data.loadState.refresh){
                is LoadState.Error->{
                   ErrorMovie(
                       message = data.error.message.toString()
                   )
                }
                is LoadState.Loading->{
                    LoadingMovies()
                }
                else->{}
            }
        }



}



}

@Composable
fun ErrorMovie(message:String){

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = message,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red

        )


    }
}



@Composable
fun LoadingMovies(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .width(42.dp)
                .height(42.dp)
                .padding(12.dp)
            ,
            strokeWidth = 5.dp
        )

    }
}

@Composable
fun MovieItems(filmName:String, imageUri:String,imagePreviewUri:String) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .size(
                width = 0.dp,
                height = 300.dp
            )
            .padding(
                bottom = 16.dp,
                start = 8.dp,
                end = 8.dp,
                top = 8.dp
            )

    ) {
        BoxWithConstraints(
            contentAlignment = Alignment.Center
        ) {
            Box {
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


