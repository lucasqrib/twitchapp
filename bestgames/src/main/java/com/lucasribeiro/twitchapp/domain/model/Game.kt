package com.lucasribeiro.twitchapp.domain.model

import com.lucasribeiro.twitchapp.data.model.GameResponse
import com.lucasribeiro.commons.extensions.setImageSize

data class Game(val id: String, val name: String, val image: String) {

    companion object {
        fun fromResponse(games: List<GameResponse>) = games.map {
            Game(
                id = it.id,
                name = it.name,
                image = it.image.setImageSize(600, 300)
            )
        }
    }
}