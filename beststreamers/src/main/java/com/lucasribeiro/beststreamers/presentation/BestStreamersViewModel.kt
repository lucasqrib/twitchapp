package com.lucasribeiro.beststreamers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

import com.lucasribeiro.beststreamers.domain.model.Stream
import com.lucasribeiro.beststreamers.domain.usecase.GetStreamsUseCase

class BestStreamersViewModel(getStreams: GetStreamsUseCase) : ViewModel() {
    val streams: LiveData<PagedList<Stream>> = getStreams.execute(null)
}