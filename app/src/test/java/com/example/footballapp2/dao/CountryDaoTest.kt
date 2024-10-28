package com.example.footballapp2.dao
/*
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.footballapp2.data.AppDatabase
import com.example.footballapp2.data.dao.CountryDao
import com.example.footballapp2.data.entity.Country
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CountryDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: CountryDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        dao = database.countryDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAndRetrieveCountry() = runBlocking {
        val country = Country("Test Country", "TC", "test_flag_url")
        dao.insertAll(listOf(country))

        val allCountries = dao.getAllCountries()
        assertEquals(allCountries.size, 1)
        assertEquals(allCountries[0], country)
    }
}
*/