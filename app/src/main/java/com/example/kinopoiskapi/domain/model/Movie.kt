package com.example.kinopoiskapi.domain.model

import com.example.kinopoiskapi.data.model.Doc

import com.example.kinopoiskapi.presentation.model.MovieUI


data class Movie(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
){



}



