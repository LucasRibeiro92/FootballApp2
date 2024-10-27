package com.example.footballapp2

import android.app.Application
import com.example.footballapp2.di.AppModule
import com.example.footballapp2.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FootballApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FootballApp)
            modules(listOf(NetworkModule, AppModule))
        }
    }
}