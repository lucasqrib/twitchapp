package com.lucasribeiro.commons.base

import androidx.paging.DataSource

class BaseDataSourceFactory<D : DataSource<K, O>, K, O>(private val dataSource: D) :
    DataSource.Factory<K, O>() {
    override fun create(): DataSource<K, O> {
        return dataSource
    }
}