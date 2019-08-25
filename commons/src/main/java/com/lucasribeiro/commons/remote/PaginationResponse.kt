package com.lucasribeiro.commons.remote

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("cursor")
    val cursor: String
)