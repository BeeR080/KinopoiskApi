package com.example.kinopoiskapi.data.api

import com.example.kinopoiskapi.data.model.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


private const val API_KEY ="2PJE0EH-667MW1K-MGHY5ZH-V41FKW6"

interface ApiService {
    @GET("/v1.4/movie")
    suspend fun getMovie(
      @Header("X-API-KEY") apikey:String = API_KEY,

    ):Response<MovieDto>

    @GET("/v1.4/movie")
    suspend fun getMovie(
        @Header("X-API-KEY") apikey:String = API_KEY,
        @Query("page") page:Int,
        @Query("limit") limit:Int
        ):Response<MovieDto>



}