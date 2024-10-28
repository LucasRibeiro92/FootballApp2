package com.example.footballapp2.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.example.footballapp2.R // Substitua pelo caminho correto do JSON

@Composable
fun LoadingAnimatedScreen(modifier: Modifier = Modifier) {
    // Carrega o JSON da animação do diretório `res/raw`
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_animation)) // Nome do arquivo JSON

    // Controle de animação com play infinito
    LottieAnimation(
        composition = composition,
        iterations = Int.MAX_VALUE,
        modifier = modifier
    )
}