package com.popular.movies.infrastructure.sqs

import com.popular.movies.infrastructure.rest.dto.RateMovieDto
import io.micronaut.jms.annotations.JMSProducer
import io.micronaut.jms.annotations.Queue
import io.micronaut.jms.sqs.configuration.SqsConfiguration.CONNECTION_FACTORY_BEAN_NAME
import io.micronaut.messaging.annotation.MessageBody

@JMSProducer(CONNECTION_FACTORY_BEAN_NAME)
interface RateMovieSqsProducer {

    @Queue("\${rate.movie.sqs.queue.name}")
    fun send(@MessageBody rateMovieDto: RateMovieDto)
}