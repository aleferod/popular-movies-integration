package com.popular.movies.application

import com.popular.movies.infrastructure.rest.client.MovieDbClient
import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import jakarta.inject.Singleton

@Singleton
class MovieDbUseCase (private val movieDbClient: MovieDbClient) {

    fun getPopularMovies (): MovieDbDto{
        return movieDbClient.getPopularMovies()
    }
}