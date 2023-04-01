package com.example.noteapp.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.core.HomeConstants.APP_NAME
import com.example.noteapp.ui.theme.AppFont
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navigateToHomeScreen: () -> Unit) {

    val offsetY = remember { Animatable(0f) }
    val fontScale = remember { Animatable(1f) }

    LaunchedEffect(Unit) {
        offsetY.animateTo(
            targetValue = -100f,
            animationSpec = tween(durationMillis = 1000)
        )
        fontScale.animateTo(
            targetValue = if (offsetY.value == 0f) 1f else 1.5f,
            animationSpec = tween(durationMillis = 500)
        )
    }

    LaunchedEffect(Unit) {
        delay(1300)
        navigateToHomeScreen()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = APP_NAME,
            fontFamily = AppFont.great_sailor,
            fontSize = with(LocalDensity.current) {
                MaterialTheme.typography.titleLarge.fontSize.value * fontScale.value
            }.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.offset(y = offsetY.value.dp)
        )
    }
}

