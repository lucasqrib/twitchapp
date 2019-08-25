package com.lucasribeiro.twitchapp.data.remote

import com.lucasribeiro.twitchapp.data.model.GameResponse
import com.lucasribeiro.commons.remote.BasePaginatedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesAPI {

    @GET("games/top")
    suspend fun getTopGames(@Query("after") after: String?): BasePaginatedResponse<GameResponse>
}