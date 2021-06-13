package com.heroes.data.remote

import com.squareup.moshi.Json

data class Image(
    @field:Json(name = "url") val url: String,
)
