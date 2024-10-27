package com.example.footballapp2.data.remote

import com.example.footballapp2.data.entity.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface FootballApiService {

    @GET("countries")
    suspend fun getCountries(): Response<CountryResponse>

    /*
    @GET("cards/{id}")
    suspend fun getCard(@Path("id") id: String): Response<CardResponse>

    @GET("cards/random")
    suspend fun getRandomCard(): Response<CardResponse>
    */
}