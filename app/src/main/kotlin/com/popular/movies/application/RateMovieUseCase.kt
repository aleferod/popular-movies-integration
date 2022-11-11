package com.popular.movies.application

import com.popular.movies.infrastructure.rest.dto.RateMovieDto
import com.popular.movies.infrastructure.sqs.RateMovieSqsProducer
import jakarta.inject.Singleton

@Singleton
class RateMovieUseCase (
        private val rateMovieSqsProducer: RateMovieSqsProducer
        ){

    fun rateMovie(rateMovieDto: RateMovieDto) {
        rateMovieSqsProducer.send(rateMovieDto)
    }

}