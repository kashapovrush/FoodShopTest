package com.kashapovrush.splashcreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kashapovrush.palette.R
import kotlinx.coroutines.delay


@Preview
@Composable
fun SplashScreen() {
    Scaffold(Modifier.fillMaxSize(), content = {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = R.drawable.logo,
                contentDescription = null,
                modifier = Modifier
                    .width(177.dp)
                    .height(77.dp)
            )
        }
    }, contentColor = Color.DarkGray)
}

@Composable
fun SplashScreenWithDelay(navigateToDestination: () -> Unit) {
    SplashScreen()
    LaunchedEffect(Unit) {
        delay(3000)
        navigateToDestination()
    }
}
