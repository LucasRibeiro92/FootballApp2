package com.example.footballapp2.di

import com.example.footballapp2.data.remote.FootballApiService
import com.example.footballapp2.util.ApiHelper.BASE_API_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(FootballApiService::class.java) }
}