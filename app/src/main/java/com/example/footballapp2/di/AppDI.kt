package com.example.footballapp2.di

import android.content.Context
import androidx.room.Room
import com.example.footballapp2.data.db.FootballDatabase
import com.example.footballapp2.util.DBHelper.FOOTBALL_DATABASE

fun provideDatabase(context: Context): FootballDatabase =
    Room.databaseBuilder(context, FootballDatabase::class.java, FOOTBALL_DATABASE)
        .fallbackToDestructiveMigration()
        .build()

fun provideCountryDao(db: FootballDatabase) = db.countryDao()