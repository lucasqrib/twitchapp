package com.lucasribeiro.twitchapp.data.model

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("box_art_url")
    val image: String
)