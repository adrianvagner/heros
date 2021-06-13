package com.heroes.data.remote

import com.squareup.moshi.Json

data class Hero(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "image") val image: Image,
    @field:Json(name = "powerstats") val powerStats: PowerStats,
)
