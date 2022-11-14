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
    private val movieDbClient: MovieDbClient,
    private val LOGGER: Logger = LoggerFactory.getLogger(MovieDbUseCase::class.java)
) {

    fun getPopularMovies(): MovieDbDto {
        try {
            LOGGER.info("Initializing the request to MovieDB external API")
            val popularMovies = movieDbClient.getPopularMovies()
            LOGGER.info("Data received successfully from MovieDB API")
            return popularMovies
        } catch (exception: Exception) {
            val stringWriter = StringWriter()
            exception.printStackTrace(PrintWriter(stringWriter))
            val exceptionAsString = stringWriter.toString()
            throw RuntimeException("Could not get data from MovieDB API. Reason: $exceptionAsString")
        }
    }
}