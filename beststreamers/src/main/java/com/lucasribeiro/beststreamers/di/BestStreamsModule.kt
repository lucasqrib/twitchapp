package com.lucasribeiro.beststreamers.di

import com.lucasribeiro.beststreamers.data.datasource.StreamsDataSource
import com.lucasribeiro.beststreamers.data.remote.StreamsApi
import com.lucasribeiro.beststreamers.data.remote.StreamsApiMock
import com.lucasribeiro.beststreamers.domain.model.Stream
import com.lucasribeiro.beststreamers.domain.usecase.GetStreamsUseCase
import com.lucasribeiro.beststreamers.domain.usecase.GetStreamsUseCaseImpl
import com.lucasribeiro.beststreamers.presentation.BestStreamersViewModel
import com.lucasribeiro.commons.base.BaseDataSourceFactory
import com.lucasribeiro.commons.remote.resolveRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object BestStreamsModule {
    private const val STREAMS = "STREAMS"
    val module = module {

        single<StreamsApi> {
            resolveRetrofit() ?: StreamsApiMock
        }

        single {
            StreamsDataSource(
                api = get()
            )
        }

        single(named(STREAMS)) {
            BaseDataSourceFactory<StreamsDataSource, String, Stream>(
                dataSource = get()
            )
        }

        factory<GetStreamsUseCase> {
            GetStreamsUseCaseImpl(
                dataSourceFactory = get(named(STREAMS))
            )
        }
        viewModel { BestStreamersViewModel(getStreams = get()) }
    }
}