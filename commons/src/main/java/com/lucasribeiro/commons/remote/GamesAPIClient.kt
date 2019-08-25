package com.lucasribeiro.commons.remote

import com.lucasribeiro.commons.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GamesAPIClient {

    inline fun <reified T> provideRetrofit(apiUrl: String): T {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(apiUrl)
            .client(provideClient())
            .build().create(T::class.java)
    }

    fun provideClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
            .addInterceptor(getClientInterceptor())
            .build()
    }

    private fun getClientInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request().newBuilder()
                .addHeader("Client-ID", BuildConfig.CLIENT_KEY)
                .build()
            it.proceed(request)
        }
    }

}