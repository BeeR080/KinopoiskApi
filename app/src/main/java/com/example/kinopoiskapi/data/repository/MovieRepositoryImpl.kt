package com.example.kinopoiskapi.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.kinopoiskapi.NetworkResult
import com.example.kinopoiskapi.data.RemoteDataSource
import com.example.kinopoiskapi.domain.model.Movie
import com.example.kinopoiskapi.domain.repository.MovieRepository
import com.example.kinopoiskapi.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
):MovieRepository {

    override suspend fun getMovies() :NetworkResult<Movie>{
      val movie = remoteDataSource.getMovie()
        return movie.map { it.toMovie() }
    }

    override  fun getMoviesPaging(): Flow<PagingData<Movie>> {
        val moviePaging = remoteDataSource.getMoviePaging()
        return moviePaging.let {
            it.map {pagingMovie->
                pagingMovie.map { movieDto->
                    movieDto.toMovie()
                }
            }
        }
    }
}