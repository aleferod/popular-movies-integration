package com.popular.movies.infrastructure.sqs

import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import io.micronaut.aws.sdk.v1.EnvironmentAWSCredentialsProvider
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Property
import io.micronaut.context.env.Environment
import jakarta.inject.Singleton


@Factory
class SqsClientFactory(
    @Property(name = "aws.localstack.url")
    val awsLocalStackUrl: String,
    @Property(name = "aws.localstack.region")
    val awsLocalStackRegion: String
) {


    @Singleton
    fun sqsClient(environment: Environment?): AmazonSQS? {
        return AmazonSQSClientBuilder
            .standard()
            .withCredentials(EnvironmentAWSCredentialsProvider(environment))
            .withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(
                    awsLocalStackUrl,
                    awsLocalStackRegion
                )
            )
            .build()
    }
}