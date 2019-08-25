package com.lucasribeiro.beststreamers.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.lucasribeiro.beststreamers.data.datasource.StreamsDataSource

import com.lucasribeiro.beststreamers.domain.model.Stream
import com.lucasribeiro.commons.base.BaseDataSourceFactory

class GetStreamsUseCaseImpl(private val dataSourceFactory: BaseDataSourceFactory<StreamsDataSource, String, Stream>) :
    GetStreamsUseCase {
    override fun execute(param: String?): LiveData<PagedList<Stream>> {
        val pagedListConfig = PagedList.Config.Builder().setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(40).build()
        return LivePagedListBuilder(dataSourceFactory, pagedListConfig).build()
    }

}