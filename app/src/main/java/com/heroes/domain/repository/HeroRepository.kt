package com.heroes.domain.repository

import com.heroes.data.remote.ApiResult
import com.heroes.data.service.factory.HeroServiceFactory
import com.heroes.domain.dto.HeroDto
import com.heroes.domain.dto.ImageDto
import com.heroes.domain.dto.PowerStatsDto
import retrofit2.HttpException

class HeroRepository {

    private val service = HeroServiceFactory.getService()

    suspend fun getList(name: String): ApiResult<List<HeroDto>> {
        return try {
            val response = service.getList(name)
            val books = response.heroes.map { hero ->
                HeroDto(
                    id = hero.id,
                    image = ImageDto(
                        url = hero.image.url
                    ),
                    name = hero.name,
                    powerStats = PowerStatsDto(
                        hero.powerStats.intelligence,
                        hero.powerStats.strength,
                        hero.powerStats.speed,
                        hero.powerStats.durability,
                        hero.powerStats.power,
                        hero.powerStats.combat,
                    ),

                )
            }

            ApiResult.Success(books)
        } catch (error: HttpException) {
            handleError(error)
        }
    }


    private fun handleError(error: HttpException): ApiResult<Nothing> {
        return if (error.code() == 404) {
            ApiResult.NoResult
        } else {
            ApiResult.ServerError
        }
    }

}