package com.example.kinopoiskapi.data.model

import com.example.kinopoiskapi.domain.model.Movie
import com.example.kinopoiskapi.presentation.model.MovieUI

data class Doc(
    val ageRating: Int,
    val alternativeName: String,
    val audience: List<Audience>,
    val backdrop: Backdrop,
    val budget: Budget,
    val countries: List<Country>,
    val createdAt: String,
    val description: String,
    val enName: String,
    val externalId: ExternalId,
    val facts: List<Fact>,
    val fees: Fees,
    val genres: List<Genre>,
    val id: Int,
    val imagesInfo: ImagesInfo,
    val isSeries: Boolean,
    val lists: List<String>,
    val logo: Logo?,
    val movieLength: Int,
    val name: String,
    val names: List<Name>,
    val networks: List<Network>,
    val persons: List<Person>,
    val poster: Poster,
    val premiere: Premiere,
    val rating: Rating,
    val ratingMpaa: String,
    val releaseYears: List<ReleaseYear>,
    val reviewInfo: ReviewInfo,
    val seasonsInfo: List<SeasonsInfo>,
    val sequelsAndPrequels: List<SequelsAndPrequel>,
    val seriesLength: Int,
    val shortDescription: String,
    val similarMovies: List<SimilarMovy>,
    val slogan: String,
    val status: String,
    val ticketsOnSale: Boolean,
    val top10: Int,
    val top250: Int,
    val totalSeriesLength: Int,
    val type: String,
    val typeNumber: Int,
    val updatedAt: String,
    val videos: Videos,
    val votes: Votes,
    val watchability: Watchability,
    val year: Int
){

    fun toMovieUi():MovieUI{

        return MovieUI(
            name = name,
            imageUrl = backdrop.url,
            imageLogoUrl = logo?.url
        )

    }
}


