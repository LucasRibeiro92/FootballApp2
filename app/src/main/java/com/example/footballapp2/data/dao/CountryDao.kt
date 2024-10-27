package com.example.footballapp2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapp2.data.entity.Country
import com.example.footballapp2.util.DBHelper.COUNTRY_TABLE

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(country: Country)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(countries: List<Country>)

    @Query("SELECT * FROM $COUNTRY_TABLE")
    fun getAllCountries(): List<Country>

}