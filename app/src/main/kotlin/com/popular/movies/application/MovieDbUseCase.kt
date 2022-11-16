package com.popular.movies.application

import com.popular.movies.infrastructure.rest.client.MovieDbClient
import com.popular.movies.infrastructure.rest.dto.MovieDbDto
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.PrintWriter
import java.io.StringWriter

@Singleton
class MovieDbUseCase(
    private val movieDbClient: MovieDbClient
    ) {

    private val logger: Logger = LoggerFactory.getLogger(MovieDbUseCase::class.java)

    fun getPopularMovies(): MovieDbDto {
        try {
            logger.info("Initializing the request to MovieDB external API")
            val popularMovies = movieDbClient.getPopularMovies()
            logger.info("Data received successfully from MovieDB API. Result size: " + popularMovies.results.size)
            return popularMovies
        } catch (exception: Exception) {
            val stringWriter = StringWriter()
            exception.printStackTrace(PrintWriter(stringWriter))
            val exceptionAsString = stringWriter.toString()
            throw RuntimeException("Could not get data from MovieDB API. Reason: $exceptionAsString")
        }
    }
}