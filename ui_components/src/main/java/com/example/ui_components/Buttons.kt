package com.example.ui_components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_components.theme.PurpleDark
import com.example.ui_components.theme.PurpleLight
import com.example.ui_components.theme.White

@Composable
fun PrimaryButton(
    modifier: Modifier,
    text: String,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = !isLoading && enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PurpleLight,
            contentColor = PurpleDark,
            disabledContainerColor = PurpleLight.copy(alpha = 0.1f)
        )
    ) {
        if (isLoading)
            CircularProgressIndicator(
                modifier = Modifier.size(30.dp),
                color = PurpleLight
            )
        else
            Text(
                text = text,
                fontSize = 16.sp
            )
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier,
    text: String,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = White.copy(alpha = 0.6f),
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        enabled = !isLoading && enabled
    ) {
        if (isLoading)
            CircularProgressIndicator(
                modifier = Modifier.size(30.dp),
                color = White.copy(alpha = 0.6f)
            )
        else
            Text(
                text = text,
                fontSize = 16.sp
            )
    }
}
