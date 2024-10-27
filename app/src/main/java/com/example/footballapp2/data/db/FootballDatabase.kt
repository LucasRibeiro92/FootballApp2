package com.example.footballapp2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.footballapp2.data.dao.CountryDao
import com.example.footballapp2.data.entity.Country
import com.example.footballapp2.util.DBHelper.FOOTBALL_DATABASE

@Database(entities = [Country::class], version = 1)
abstract class FootballDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object {
        @Volatile private var instance: FootballDatabase? = null

        fun getInstance(context: Context): FootballDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                FootballDatabase::class.java, FOOTBALL_DATABASE)
                .fallbackToDestructiveMigration()
                .build()
    }
}