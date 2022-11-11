package com.popular.movies.infrastructure.rest.dto

import io.micronaut.core.annotation.Introspected

@Introspected
data class RateMovieDto (
        val id: Long,
        val tittle: String,
        val comment: String,
        val rate: Int
        )