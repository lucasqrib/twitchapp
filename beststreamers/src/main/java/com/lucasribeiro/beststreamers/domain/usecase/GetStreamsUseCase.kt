package com.lucasribeiro.beststreamers.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.lucasribeiro.beststreamers.domain.model.Stream
import com.lucasribeiro.commons.base.BaseUseCase

interface GetStreamsUseCase :
    BaseUseCase<String?, LiveData<PagedList<Stream>>>