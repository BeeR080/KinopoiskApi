package com.example.kinopoiskapi.data.repository

import com.example.kinopoiskapi.NetworkResult
import com.example.kinopoiskapi.data.RemoteDataSource
import com.example.kinopoiskapi.domain.model.Movie
import com.example.kinopoiskapi.domain.repository.MovieRepository
import com.example.kinopoiskapi.map
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):MovieRepository {

    override suspend fun getMovies() :NetworkResult<Movie>{
      val movie = remoteDataSource.getMovie()
        return movie.map { it.toMovie() }
    }
}