package com.example.footballapp2.di

import com.example.footballapp2.data.repository.FootballRepository
import com.example.footballapp2.vm.FootballViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    // ViewModels
    viewModel { FootballViewModel(get()) }

    // Repository
    single { FootballRepository(get(), get()) }

    // Database and DAOs
    single { provideDatabase(get()) }
    single { provideCountryDao(get()) }
}