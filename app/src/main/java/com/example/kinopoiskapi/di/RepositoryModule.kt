package com.example.kinopoiskapi.di

import com.example.kinopoiskapi.data.repository.MovieRepositoryImpl
import com.example.kinopoiskapi.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideWeatherRepositoryImpl(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

}