package com.lucasribeiro.twitchapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.lucasribeiro.twitchapp.domain.model.Game
import com.lucasribeiro.twitchapp.domain.usecase.GetGamesUseCase

class BestGamesViewModel(val getGames: GetGamesUseCase) : ViewModel() {
    val games: LiveData<PagedList<Game>> = getGames.execute(null)
}