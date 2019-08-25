package com.lucasribeiro.beststreamers.data.remote

import com.lucasribeiro.beststreamers.data.model.StreamResponse
import com.lucasribeiro.commons.remote.BasePaginatedResponse
import com.lucasribeiro.commons.remote.PaginationResponse

object StreamsApiMock : StreamsApi {
    override suspend fun getTopStreams(after: String?): BasePaginatedResponse<StreamResponse> {
        return BasePaginatedResponse(
            data = listOf(),
            paginationResponse = PaginationResponse("")
        )
    }

}