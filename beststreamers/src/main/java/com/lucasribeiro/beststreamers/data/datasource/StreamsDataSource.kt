package com.lucasribeiro.beststreamers.data.datasource

import androidx.paging.PageKeyedDataSource
import com.lucasribeiro.beststreamers.data.remote.StreamsApi
import com.lucasribeiro.beststreamers.domain.model.Stream
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class StreamsDataSource(val api: StreamsApi) : PageKeyedDataSource<String, Stream>(),
    CoroutineScope by MainScope() {
    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, Stream>
    ) {
        launch {
            try {
                val response = api.getTopStreams(null)
                callback.onResult(
                    Stream.fromResponse(response.data),
                    null,
                    response.paginationResponse.cursor
                )
            } catch (error: Throwable) {
                error.printStackTrace()
            }
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Stream>) {
        launch {
            try {
                val response = api.getTopStreams(params.key)
                callback.onResult(
                    Stream.fromResponse(response.data),
                    response.paginationResponse.cursor
                )
            } catch (error: Throwable) {
                error.printStackTrace()
            }
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Stream>) {
    }
}