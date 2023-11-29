package com.example.kinopoiskapi.data.model

import com.example.kinopoiskapi.domain.model.Movie

data class MovieDto(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
){


    fun toMovie():Movie{
        return Movie(
            docs = docs,
            limit = limit,
            page =page,
            pages = pages,
            total = total
        )

    }
}