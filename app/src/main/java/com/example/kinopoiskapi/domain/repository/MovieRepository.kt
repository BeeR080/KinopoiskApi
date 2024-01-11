package com.example.kinopoiskapi.domain.repository

import androidx.paging.PagingData
import com.example.kinopoiskapi.NetworkResult
import com.example.kinopoiskapi.data.model.MovieDto
import com.example.kinopoiskapi.domain.model.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

   suspend fun getMovies(): NetworkResult<Movie>

    fun getMoviesPaging(): Flow<PagingData<Movie>>
}