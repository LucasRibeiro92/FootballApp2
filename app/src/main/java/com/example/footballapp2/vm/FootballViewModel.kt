package com.example.footballapp2.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp2.data.entity.Country
import com.example.footballapp2.data.repository.FootballRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FootballViewModel(
    private val footballRepository: FootballRepository
)  : ViewModel() {

    private val _countriesState = MutableStateFlow<DataState<List<Country>>>(DataState.Loading)
    val countriesState = _countriesState.asStateFlow()

    private fun getCountries() {
        viewModelScope.launch {
            try {
                _countriesState.value = DataState.Loading
                footballRepository.fetchAndSaveCountries()
                val countries = footballRepository.getCountriesFromLocal()
                _countriesState.value = DataState.Success(countries)
            } catch (e: Exception) {
                _countriesState.value = DataState.Error("Erro ao carregar países: ${e.message}")
            }
        }
    }

    init {
        getCountries()
    }

}

sealed class DataState<out T> {
    data object Loading : DataState<Nothing>()
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val message: String) : DataState<Nothing>()
}

/* Not in use */

/*
sealed class FootballAppState {
    data object Loading : FootballAppState()
    data class Success(
        val where: Int? = 0
    ) : FootballAppState()
    data class Error(val message: String) : FootballAppState()
}
*/