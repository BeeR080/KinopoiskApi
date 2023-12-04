package com.example.kinopoiskapi

import com.example.kinopoiskapi.data.model.Doc


data class MovieUiState(
    val data: List<Doc>? =null,
    val error:String?=null,
    val loading:Boolean = false
    )