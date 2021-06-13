package com.heroes.data.remote

import com.squareup.moshi.Json

data class PowerStats(
    @field:Json(name = "intelligence") val intelligence: String,
    @field:Json(name = "strength") val strength: String,
    @field:Json(name = "speed") val speed: String,
    @field:Json(name = "durability") val durability: String,
    @field:Json(name = "power") val power: String,
    @field:Json(name = "combat") val combat: String,


)
