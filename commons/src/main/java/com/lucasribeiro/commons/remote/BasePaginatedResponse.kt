package com.lucasribeiro.commons.remote

import com.google.gson.annotations.SerializedName

data class BasePaginatedResponse<T>(
    @SerializedName("data") val data: List<T>,
    @SerializedName("pagination") val paginationResponse: PaginationResponse
)