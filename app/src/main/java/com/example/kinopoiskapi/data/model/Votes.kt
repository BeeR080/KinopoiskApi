package com.example.kinopoiskapi.data.model

data class Votes(
    val await: Int,
    val filmCritics: Int,
    val imdb: Int,
    val kp: String,
    val russianFilmCritics: Int,
    val tmdb: Int
)