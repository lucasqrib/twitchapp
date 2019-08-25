package com.lucasribeiro.twitchapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.lucasribeiro.commons.base.BaseDataSourceFactory
import com.lucasribeiro.twitchapp.data.datasource.GameDataSource
import com.lucasribeiro.twitchapp.domain.model.Game

class GetGamesUseCaseImpl(private val dataSourceFactory: BaseDataSourceFactory<GameDataSource, String, Game>) :
    GetGamesUseCase {
    override fun execute(param: String?): LiveData<PagedList<Game>> {
        val pagedListConfig = PagedList.Config.Builder().setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(40).build()
        return LivePagedListBuilder(dataSourceFactory, pagedListConfig).build()
    }

}