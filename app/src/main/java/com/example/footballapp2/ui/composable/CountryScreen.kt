package com.example.footballapp2.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.footballapp2.vm.DataState
import com.example.footballapp2.vm.FootballViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CountryScreen(viewModel: FootballViewModel = getViewModel()) {
    val countriesState = viewModel.countriesState.collectAsState()

    when (val state = countriesState.value) {
        is DataState.Loading -> {
            CircularProgressIndicator()
        }
        is DataState.Success -> {
            LazyColumn {
                items(state.data) { country ->
                    Column() {
                        Text(country.name)
                        Text(country.flag)
                    }
                }
            }
        }
        is DataState.Error -> {
            Text("Erro: ${state.message}")
        }
    }
}