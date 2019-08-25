package com.lucasribeiro.twitchapp.data.remote

import com.lucasribeiro.twitchapp.data.model.GameResponse
import com.lucasribeiro.commons.remote.BasePaginatedResponse
import com.lucasribeiro.commons.remote.PaginationResponse

class GamesApiMock : GamesAPI {
    override suspend fun getTopGames(after: String?): BasePaginatedResponse<GameResponse> {
        return BasePaginatedResponse(
            data = listOf(),
            paginationResponse = PaginationResponse("")
        )
    }
}