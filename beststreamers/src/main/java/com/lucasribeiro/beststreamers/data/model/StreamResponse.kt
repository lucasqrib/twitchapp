package com.lucasribeiro.beststreamers.data.model

import com.google.gson.annotations.SerializedName

data class StreamResponse(
    @SerializedName("id") val id: String,
    @SerializedName("user_id") val userId: String,
    @SerializedName("user_name") val userName: String,
    @SerializedName("game_id") val gameId: String,
    @SerializedName("title") val title: String,
    @SerializedName("viewer_count") val viewerCount: Int,
    @SerializedName("thumbnail_url") val image: String
)
