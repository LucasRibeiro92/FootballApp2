package com.example.footballapp2.vm
/*
import app.cash.turbine.test
import com.example.footballapp2.data.entity.Country
import com.example.footballapp2.data.repository.FootballRepository
import com.example.footballapp2.repository.CountryRepository
import com.example.footballapp2.viewmodel.FootballViewModel
import com.example.footballapp2.vm.FootballViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class FootballViewModelTest {

    private lateinit var viewModel: FootballViewModel
    private val repository = mockk<FootballRepository>()
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = FootballViewModel(repository)
    }

    @Test
    fun `should emit loading and success states`() = testScope.runTest {
        val mockCountries = listOf(
            Country(name = "Albania", code = "AL", flag = "https://media.api-sports.io/flags/al.svg"),
            Country(name = "Algeria", code = "DZ", flag = "https://media.api-sports.io/flags/dz.svg")
        )
        coEvery { repository.fetchCountries() } returns flowOf(mockCountries)

        viewModel.uiState.test {
            assertEquals(Loading, awaitItem())
            assertEquals(Success(mockCountries), awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `should emit error state on failure`() = testScope.runTest {
        coEvery { repository.fetchCountries() } throws Exception("API Error")

        viewModel.uiState.test {
            assertEquals(Loading, awaitItem())
            assertEquals(Error("API Error"), awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }
}
*/