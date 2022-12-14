package com.popular.movies.application

import com.popular.movies.infrastructure.rest.client.MovieDbClient
import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import jakarta.inject.Singleton
import org.reactivestreams.Publisher
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.PrintWriter
import java.io.StringWriter

@Singleton
class MovieDbUseCase(
    private val movieDbClient: MovieDbClient
    ) {

    private val logger: Logger = LoggerFactory.getLogger(MovieDbUseCase::class.java)

    fun getPopularMovies(): Publisher<MovieDbDto> {
        try {
            logger.info("Initializing the request to MovieDB external API")
            val popularMovies = movieDbClient.getPopularMovies()
            logger.info("Data received successfully from MovieDB API")
            return popularMovies
        } catch (exception: Exception) {
            val stringWriter = StringWriter()
            exception.printStackTrace(PrintWriter(stringWriter))
            val exceptionAsString = stringWriter.toString()
            logger.error("Could not get data from MovieDB API. Reason: $exceptionAsString")
            throw RuntimeException("Could not get data from MovieDB API. Reason: $exceptionAsString")
        }
    }
}