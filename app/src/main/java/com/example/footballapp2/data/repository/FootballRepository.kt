package com.example.footballapp2.data.repository

import android.util.Log
import com.example.footballapp2.data.dao.CountryDao
import com.example.footballapp2.data.entity.Country
import com.example.footballapp2.data.remote.FootballApiService
import com.example.footballapp2.util.LogHelper.TAG_REPO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FootballRepository(
    private val countryDao: CountryDao,
    private val apiService: FootballApiService
) {

    suspend fun fetchAndSaveCountries() {
        withContext(Dispatchers.IO) {
            val response = apiService.getCountries()
            //Log.d(TAG_REPO, "API Response: $response")

            if (response.isSuccessful) {
                response.body()?.response?.let { countryList ->
                    //Log.d(TAG_REPO, "Country List from Response: $countryList")

                    try {
                        // Mapeia e loga cada item da lista de países
                        val countries = countryList.map { countryResponse ->
                            //Log.d(TAG_REPO, "Mapping Country: $countryResponse")
                            Country(
                                name = countryResponse.name,
                                code = countryResponse.code,
                                flag = countryResponse.flag
                            )
                        }
                        //Log.d(TAG_REPO, "Mapped Countries: $countries")

                        // Insere os dados no banco
                        countryDao.insertAll(countries)
                        //Log.d(TAG_REPO, "Data inserted into DB successfully.")

                    } catch (e: Exception) {
                        //Log.e(TAG_REPO, "Error mapping countries: ${e.message}")
                        throw Exception("Erro ao mapear os países: ${e.message}")
                    }
                } ?: run {
                    //Log.e(TAG_REPO, "Resposta vazia ou não no formato esperado.")
                    throw Exception("Resposta vazia ou não no formato esperado.")
                }
            } else {
                //Log.e(TAG_REPO, "Erro na resposta da API: ${response.message()}")
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