package com.example.footballapp2.repository

import com.example.footballapp2.data.dao.CountryDao
import com.example.footballapp2.data.entity.Country
import com.example.footballapp2.data.entity.CountryResponse
import com.example.footballapp2.data.remote.FootballApiService
import com.example.footballapp2.data.repository.FootballRepository
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FootballRepositoryTest {

    private lateinit var repository: FootballRepository
    private val apiService: FootballApiService = mockk()
    private val countryDao: CountryDao = mockk()

    @Before
    fun setUp() {
        repository = FootballRepository(countryDao, apiService)
    }

    @Test
    fun `test fetchAndSaveCountries successful response`() = runTest {
        // Arrange: Configurar dados simulados para a resposta da API
        val countryList = listOf(
            Country(name = "Albania", code = "AL", flag = "https://media.api-sports.io/flags/al.svg"),
            Country(name = "Algeria", code = "DZ", flag = "https://media.api-sports.io/flags/dz.svg")
        )

        val mockResponse = CountryResponse(
            response = countryList
        )

        // Mockar as chamadas do ApiService e do DAO
        coEvery { apiService.getCountries() } returns retrofit2.Response.success(mockResponse)
        coEvery { countryDao.insertAll(any()) } just Runs

        // Act: Executar o método de teste
        repository.fetchAndSaveCountries()

        // Assert: Verificar se os métodos foram chamados com os parâmetros corretos
        coVerify { apiService.getCountries() }
        coVerify { countryDao.insertAll(countryList) }
    }

    @Test
    fun `test fetchAndSaveCountries error response`() = runTest {
        // Arrange: Simular uma resposta de erro da API
        coEvery { apiService.getCountries() } returns retrofit2.Response.error(404, mockk(relaxed = true))

        // Act & Assert
        try {
            repository.fetchAndSaveCountries()
            fail("Expected an exception to be thrown")
        } catch (e: Exception) {
            assertTrue(e.message?.contains("Erro na resposta da API") == true)
        }

        // Verificar que o DAO não foi chamado em caso de erro
        coVerify(exactly = 0) { countryDao.insertAll(any()) }
    }
}