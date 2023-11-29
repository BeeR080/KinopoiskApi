package com.example.kinopoiskapi.domain.repository

import com.example.kinopoiskapi.NetworkResult
import com.example.kinopoiskapi.domain.model.Movie


interface MovieRepository {

   suspend fun getMovies(): NetworkResult<Movie>
}