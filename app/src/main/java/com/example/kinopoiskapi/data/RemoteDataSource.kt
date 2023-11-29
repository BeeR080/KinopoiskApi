package com.example.kinopoiskapi.data

import com.example.kinopoiskapi.NetworkResult
import com.example.kinopoiskapi.data.api.ApiService
import com.example.kinopoiskapi.data.model.MovieDto
import com.example.kinopoiskapi.safeResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

suspend fun getMovie():NetworkResult<MovieDto>{
    return safeResponse { apiService.getMovie() }
}

}