package com.example.footballapp2.data.repository

import com.example.footballapp2.data.dao.CountryDao
import com.example.footballapp2.data.entity.Country
import com.example.footballapp2.data.remote.FootballApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FootballRepository(
    private val countryDao: CountryDao,
    private val apiService: FootballApiService
) {

    suspend fun fetchAndSaveCountries() {
        withContext(Dispatchers.IO) {
            val response = apiService.getCountries()
            if (response.isSuccessful) {
                response.body()?.response?.let { countryResponseList ->
                    // Mapeia CountryResponse para Country
                    val countries = countryResponseList.map { country ->
                        Country(
                            name = country.name,
                            code = country.code,
                            flag = country.flag
                        )
                    }
                    countryDao.insertAll(countries)
                }
            } else {
                throw Exception("Erro na resposta da API: ${response.message()}")
            }
        }
    }

    // Método para buscar países do banco de dados local
    suspend fun getCountriesFromLocal(): List<Country> {
        return withContext(Dispatchers.IO){
            countryDao.getAllCountries()
        }
    }

    /* Not in use */

    /*
    // Save a Country into Room
    suspend fun saveCountry(country: Country) {
        withContext(Dispatchers.IO) {
            try {
                countryDao.insert(country)
            } catch (e: Exception) {
                throw e
            }
        }
    }
    */
}