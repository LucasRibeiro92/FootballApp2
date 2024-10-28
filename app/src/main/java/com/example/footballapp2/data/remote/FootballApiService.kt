package com.example.footballapp2.data.remote

import com.example.footballapp2.data.entity.CountryResponse
import com.example.footballapp2.util.ApiHelper.API_HOST
import com.example.footballapp2.util.ApiHelper.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface FootballApiService {

    @Headers(
        "x-rapidapi-key: $API_KEY",
        "x-rapidapi-host: $API_HOST"
    )

    @GET("countries")
    suspend fun getCountries(): Response<CountryResponse>

    /*
    @GET("cards/{id}")
    suspend fun getCard(@Path("id") id: String): Response<CardResponse>

    @GET("cards/random")
    suspend fun getRandomCard(): Response<CardResponse>
    */
}