package com.popular.movies.application

import com.popular.movies.infrastructure.rest.dto.RateMovieDto
import com.popular.movies.infrastructure.sqs.RateMovieSqsProducer
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.PrintWriter
import java.io.StringWriter

@Singleton
class RateMovieUseCase(
    private val rateMovieSqsProducer: RateMovieSqsProducer
    ) {

    private val logger: Logger = LoggerFactory.getLogger(RateMovieUseCase::class.java)

    fun rateMovie(rateMovieDto: RateMovieDto) {
        try {
            logger.info("Sending rate as message to SQS rate-movie queue")
            rateMovieSqsProducer.send(rateMovieDto)
            logger.info("Message sent to SQS rate-movie queue")
        } catch (exception: Exception) {
            val stringWriter = StringWriter()
            exception.printStackTrace(PrintWriter(stringWriter))
            val exceptionAsString = stringWriter.toString()
            throw RuntimeException("Could not send movie rated to the SQS rate-movie queue. Reason: $exceptionAsString")
        }
    }

}