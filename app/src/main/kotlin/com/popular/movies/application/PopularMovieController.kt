package com.popular.movies.application

import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/v1")
class PopularMovieController (
        private val movieDbUseCase: MovieDbUseCase
        ){

    @Get("/popular")
    fun getPopularMovies() : HttpResponse<MovieDbDto> {
        val response = movieDbUseCase.getPopularMovies()
        return HttpResponse.status<MovieDbDto?>(HttpStatus.OK)
            .body(response)
    }
}