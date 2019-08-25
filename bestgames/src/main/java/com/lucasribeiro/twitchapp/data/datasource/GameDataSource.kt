package com.lucasribeiro.twitchapp.data.datasource

import androidx.paging.PageKeyedDataSource
import com.lucasribeiro.twitchapp.data.remote.GamesAPI
import com.lucasribeiro.twitchapp.domain.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class GameDataSource(
    val api: GamesAPI
) : PageKeyedDataSource<String, Game>(),
    CoroutineScope by MainScope() {


    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, Game>
    ) {
        launch {
            try {
                val response = api.getTopGames(null)
                callback.onResult(
                    Game.fromResponse(response.data),
                    null,
                    response.paginationResponse.cursor
                )
            } catch (error: Throwable) {
                error.printStackTrace()
            }
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Game>) {
        launch {
            try {
                val response = api.getTopGames(params.key)
                callback.onResult(
                    Game.fromResponse(response.data),
                    response.paginationResponse.cursor
                )
            } catch (error: Throwable) {
                error.printStackTrace()
            }
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Game>) {
    }


}