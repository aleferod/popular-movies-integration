package com.popular.movies.infrastructure.sqs

import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import io.micronaut.aws.sdk.v1.EnvironmentAWSCredentialsProvider
import io.micronaut.context.annotation.Factory
import io.micronaut.context.env.Environment
import jakarta.inject.Singleton


@Factory
class SqsClientFactory {

    @Singleton
    fun sqsClient(environment: Environment?): AmazonSQS? {
        return AmazonSQSClientBuilder
            .standard()
            .withCredentials(EnvironmentAWSCredentialsProvider(environment))
            .withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(
                    "http://localhost:4566",
                    "us-east-1"
                )
            )
            .build()
    }
}