package com.popular.movies.infrastructure.rest.dto

import io.micronaut.core.annotation.Introspected

@Introspected
data class MovieDbDto(
    val page: String,
    val results: List<Result>
)