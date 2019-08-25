package com.lucasribeiro.commons.remote

import com.lucasribeiro.commons.BuildConfig

inline fun <reified T> resolveRetrofit(): T? {
    return if (BuildConfig.API_URL.isNotBlank()) GamesAPIClient.provideRetrofit<T>(BuildConfig.API_URL)
    else null
}