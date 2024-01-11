package com.example.kinopoiskapi.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kinopoiskapi.NetworkResult
import com.example.kinopoiskapi.data.api.ApiService
import com.example.kinopoiskapi.data.model.MovieDto
import com.example.kinopoiskapi.safeResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

suspend fun getMovie():NetworkResult<MovieDto>{

    return safeResponse { apiService.getMovie() }
}

     fun getMoviePaging() = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {MoviePagingDataSource(apiService = apiService)}
    ).flow

}