package com.example.kinopoiskapi

import com.example.kinopoiskapi.domain.model.Movie

data class MovieUiState(
    val data: Movie? =null,
    val error:String?=null,
    val loading:Boolean = false

    )