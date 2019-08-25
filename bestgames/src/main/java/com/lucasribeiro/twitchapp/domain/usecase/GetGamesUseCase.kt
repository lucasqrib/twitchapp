package com.lucasribeiro.twitchapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.lucasribeiro.twitchapp.domain.model.Game
import com.lucasribeiro.commons.base.BaseUseCase

interface GetGamesUseCase :
    BaseUseCase<String?, LiveData<PagedList<Game>>>