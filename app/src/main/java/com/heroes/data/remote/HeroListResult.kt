package com.heroes.data.remote

import com.squareup.moshi.Json

data class HeroListResult(
    @field:Json(name = "results") val results: HeroList
)
