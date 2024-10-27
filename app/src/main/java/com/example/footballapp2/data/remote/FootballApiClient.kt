package com.example.footballapp2.data.remote

import com.example.footballapp2.util.ApiHelper.BASE_API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FootballApiClient {
    companion object {
        val apiService: FootballApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FootballApiService::class.java)
        }
    }
}