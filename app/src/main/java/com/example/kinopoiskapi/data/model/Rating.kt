package com.example.kinopoiskapi.data.model

data class Rating(
    val await: Double,
    val filmCritics: Double,
    val imdb: Double,
    val kp: Double,
    val russianFilmCritics: Double,
    val tmdb: Double
)