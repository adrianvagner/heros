package com.heroes.data.remote

import com.squareup.moshi.Json

data class HeroList(
    @field:Json(name = "results") val heroes: List<Hero>,
)
