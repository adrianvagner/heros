package com.heroes.data.service

import com.heroes.data.remote.HeroList
import com.heroes.data.remote.HeroListResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeroesService {


    @GET(WS_GET_HEROES)
    suspend fun getList(
        @Path(PARAM_NAME) listName: String,
    ): HeroList

}