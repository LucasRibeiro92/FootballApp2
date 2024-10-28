package com.example.footballapp2.ui.composable

import androidx.compose.runtime.Composable
import com.example.footballapp2.vm.FootballViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun NewUserScreen(viewModel: FootballViewModel = getViewModel()) {}