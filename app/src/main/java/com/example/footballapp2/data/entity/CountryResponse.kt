package com.example.footballapp2.data.entity

data class CountryResponse(
    //val get: String,
    val parameters: List<Any>,
    //val errors: List<Any>,
    //val results: Int,
    val paging: Paging,
    val response: List<Country>
)

data class Paging(
    val current: Int,
    val total: Int
)
