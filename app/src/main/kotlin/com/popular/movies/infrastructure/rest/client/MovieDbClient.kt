package com.popular.movies.infrastructure.rest.client

import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("https://api.themoviedb.org/3")
interface MovieDbClient {

    @Get("/movie/popular?api_key=edac97aabe9e5bc96b11219190aab292")
    fun getPopularMovies(): MovieDbDto
}