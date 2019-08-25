package com.lucasribeiro.beststreamers.domain.model

import com.lucasribeiro.beststreamers.data.model.StreamResponse
import com.lucasribeiro.commons.extensions.setImageSize

data class Stream(
    val id: String,
    val user: User,
    val gameId: String,
    val title: String,
    val viewerCount: Int,
    val image: String
) {
    companion object {
        fun fromResponse(response: List<StreamResponse>) = response.map {
            Stream(
                id = it.id,
                image = it.image.setImageSize(600, 300),
                gameId = it.gameId,
                title = it.title,
                user = User(
                    id = it.userId,
                    name = it.userName
                ),
                viewerCount = it.viewerCount
            )
        }
    }
}

