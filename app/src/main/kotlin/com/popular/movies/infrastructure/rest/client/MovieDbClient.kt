package com.popular.movies.infrastructure.rest.client

import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("\${movie.db.url}")
interface MovieDbClient {

    @Get("/movie/popular?api_key=\${movie.db.apikey}")
    fun getPopularMovies(): MovieDbDto
}