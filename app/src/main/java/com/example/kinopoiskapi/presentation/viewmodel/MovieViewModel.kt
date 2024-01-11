package com.example.kinopoiskapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kinopoiskapi.MovieUiState

import com.example.kinopoiskapi.domain.usecases.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
):ViewModel() {

    private val _uiState = MutableStateFlow(MovieUiState())
    val uiState  = _uiState.asStateFlow()





    init {

       // getMovies()
        getMovies()

    }
    fun getMovies() = getMovieUseCase.invokePaging()


 /*   fun getMovies(){
        viewModelScope.launch {
            getMovieUseCase.invoke().collect{movie->
                when(movie){
                    is NetworkResult.Success->{
                        _uiState.value = MovieUiState(data = movie.data?.docs)
                    }
                    is NetworkResult.Error->{
                        _uiState.value = MovieUiState(error = movie.message)
                    }
                    is NetworkResult.Exception->{
                        _uiState.value = MovieUiState(error = movie.exception?.message)
                    }

                    else -> {
                        _uiState.value = MovieUiState(loading = true)
                    }
                }

            }
        }
    }*/



}