package com.popular.movies.application

import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import com.popular.movies.infrastructure.rest.dto.RateMovieDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/v1")
class PopularMovieController (
        private val movieDbUseCase: MovieDbUseCase,
        private val rateMovieUseCase: RateMovieUseCase
        ){

    @Get("/popular")
    fun getPopularMovies() : HttpResponse<MovieDbDto> {
        val response = movieDbUseCase.getPopularMovies()
        return HttpResponse.status<MovieDbDto?>(HttpStatus.OK)
            .body(response)
    }

    @Post("/rate")
    fun rateMovie(@Body  rateMovieDto: RateMovieDto) : RateMovieDto {
        rateMovieUseCase.rateMovie(rateMovieDto)
        return rateMovieDto
    }
}