package com.lucasribeiro.twitchapp

import android.app.Application
import com.lucasribeiro.twitchapp.di.BestGamesModule
import com.lucasribeiro.beststreamers.di.BestStreamsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(BestGamesModule.module, BestStreamsModule.module))
        }
    }
}