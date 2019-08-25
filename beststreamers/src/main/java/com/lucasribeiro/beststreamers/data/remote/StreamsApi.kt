package com.lucasribeiro.beststreamers.data.remote

import com.lucasribeiro.beststreamers.data.model.StreamResponse
import com.lucasribeiro.commons.remote.BasePaginatedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StreamsApi {
    @GET("streams")
    suspend fun getTopStreams(@Query("after") after: String?): BasePaginatedResponse<StreamResponse>
}