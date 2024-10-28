package com.example.footballapp2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.footballapp2.util.DBHelper.COUNTRY_TABLE

@Entity(tableName = COUNTRY_TABLE)
data class Country(
    @PrimaryKey val name: String,
    val code: String? = "No code",
    val flag: String? = "No flag"
)

data class CountryResponse(
    val response: List<Country>
)
