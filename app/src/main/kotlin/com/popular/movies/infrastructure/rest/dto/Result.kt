package com.popular.movies.infrastructure.rest.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected
data class Result(
    val id: String,
    val title: String,
    val overview: String,
    @JsonProperty("poster_path")
    val posterPath: String,
    @JsonProperty("release_date")
    val releaseDate: String
)