package com.lucasribeiro.twitchapp.di

import com.lucasribeiro.commons.base.BaseDataSourceFactory
import com.lucasribeiro.twitchapp.data.datasource.GameDataSource
import com.lucasribeiro.twitchapp.data.remote.GamesAPI
import com.lucasribeiro.twitchapp.data.remote.GamesApiMock
import com.lucasribeiro.twitchapp.domain.model.Game
import com.lucasribeiro.twitchapp.domain.usecase.GetGamesUseCase
import com.lucasribeiro.twitchapp.domain.usecase.GetGamesUseCaseImpl
import com.lucasribeiro.twitchapp.presentation.BestGamesViewModel
import com.lucasribeiro.commons.remote.resolveRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object BestGamesModule {
    private const val GAME = "GAME"

    val module = module {

        single<GamesAPI> {

            resolveRetrofit() ?: GamesApiMock()
        }

        single {
            GameDataSource(
                api = get()
            )
        }

        single(named(GAME)) {
            BaseDataSourceFactory<GameDataSource, String, Game>(
                dataSource = get()
            )
        }

        factory<GetGamesUseCase> {
            GetGamesUseCaseImpl(
                dataSourceFactory = get(named(GAME))
            )
        }
        viewModel { BestGamesViewModel(getGames = get()) }
    }
}