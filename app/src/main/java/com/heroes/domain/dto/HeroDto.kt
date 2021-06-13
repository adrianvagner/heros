package com.heroes.domain.dto


data class HeroDto(
    val id: Int,
    val name: String,
    val image: ImageDto,
    val powerStats: PowerStatsDto,
)
