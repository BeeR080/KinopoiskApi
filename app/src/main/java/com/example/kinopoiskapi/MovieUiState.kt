package com.example.kinopoiskapi

import com.example.kinopoiskapi.data.model.Doc
import com.example.kinopoiskapi.domain.model.Movie

data class MovieUiState(
    val data: List<Doc>? = null,
    val error:String?= null,
    val loading:Boolean = false

    )