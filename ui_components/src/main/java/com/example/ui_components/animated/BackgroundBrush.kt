package com.example.ui_components.animated

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.ui_components.theme.Black
import com.example.ui_components.theme.Blue
import com.example.ui_components.theme.BlueDark
import com.example.ui_components.theme.Purple
import com.example.ui_components.theme.PurpleDark
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BackgroundBrush(modifier: Modifier) {

    val color1 = remember { Animatable(BlueDark) }
    val color2 = Black
    val color3 = remember { Animatable(PurpleDark) }

    LaunchedEffect(Unit) {
        while(true) {
            launch { color1.animateTo(BlueDark, animationSpec = tween(6000)) }
            delay(3000)
            launch { color3.animateTo(Purple, animationSpec = tween(6000)) }
            delay(3100)

            launch { color1.animateTo(Blue, animationSpec = tween(6000)) }
            delay(3000)
            launch { color3.animateTo(PurpleDark, animationSpec = tween(6000)) }
            delay(3100)

            launch { color1.animateTo(BlueDark, animationSpec = tween(6000)) }
            delay(3000)
            launch { color3.animateTo(BlueDark, animationSpec = tween(6000)) }
            delay(3100)

            launch { color1.animateTo(PurpleDark, animationSpec = tween(6000)) }
            delay(3000)
            launch { color3.animateTo(Blue, animationSpec = tween(6000)) }
            delay(3100)

            launch { color1.animateTo(Purple, animationSpec = tween(6000)) }
            delay(3000)
            launch { color3.animateTo(BlueDark, animationSpec = tween(6000)) }
            delay(3100)

            launch { color1.animateTo(PurpleDark, animationSpec = tween(6000)) }
            delay(3000)
            launch { color3.animateTo(PurpleDark, animationSpec = tween(6000)) }
            delay(3100)
        }
    }
    val backgroundBrush = Brush.linearGradient(listOf(color1.value, color2, color3.value))

    Box(modifier = modifier.background(backgroundBrush))
}
