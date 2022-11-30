package com.popular.movies.application

import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import com.popular.movies.infrastructure.rest.dto.RateMovieDto
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.reactivestreams.Publisher
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Controller("/v1")
class PopularMovieController(
    private val movieDbUseCase: MovieDbUseCase,
    private val rateMovieUseCase: RateMovieUseCase
    ) {

    private val logger: Logger = LoggerFactory.getLogger(PopularMovieController::class.java)

    @Get("/popular")
    fun getPopularMovies(headers: HttpHeaders): HttpResponse<Publisher<MovieDbDto>> {
        val correlationId = headers.get("x-correlation-id")
        logger.info("Receiving a request from correlationId $correlationId")
        val response = movieDbUseCase.getPopularMovies()
        return HttpResponse.status<Publisher<MovieDbDto>>(HttpStatus.OK)
            .body(response)
    }

    @Post("/rate")
    fun rateMovie(@Body rateMovieDto: RateMovieDto, headers: HttpHeaders): RateMovieDto {
        val correlationId = headers.get("x-correlation-id")
        logger.info("Receiving a request from correlationId $correlationId")
        rateMovieUseCase.rateMovie(rateMovieDto)
        logger.info("finishing ")
        return rateMovieDto
    }
}