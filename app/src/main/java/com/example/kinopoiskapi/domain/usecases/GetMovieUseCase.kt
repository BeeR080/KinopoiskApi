package com.example.kinopoiskapi.domain.usecases


import com.example.kinopoiskapi.NetworkResult
import com.example.kinopoiskapi.domain.model.Movie
import com.example.kinopoiskapi.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend fun invoke() :Flow<NetworkResult<Movie>> = flow {
        val movie = repository.getMovies()
        emit(movie)
    }

    fun invokePaging() = repository.getMoviesPaging()

}