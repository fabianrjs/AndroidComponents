package com.example.androidcomponents.ui.signin

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androidcomponents.ui.theme.Black
import com.example.androidcomponents.ui.theme.Blue
import com.example.androidcomponents.ui.theme.BlueDark
import com.example.androidcomponents.ui.theme.Purple
import com.example.androidcomponents.ui.theme.PurpleDark
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInScreen(
    viewModel: SignInViewModel = koinViewModel()
) {
    val emailOrUsername by viewModel.emailOrUsername.collectAsState()
    val password by viewModel.password.collectAsState()
    val signInLoading by viewModel.signInLoading.collectAsState()

    val keyboardController = LocalSoftwareKeyboardController.current // TODO Check when Compose BOM upgraded

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(color1.value, color2, color3.value))),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = "Welcome to Android Components", // TODO
            textAlign = TextAlign.Center,
            color = Color.Cyan
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 10.dp),
            value = emailOrUsername,
            onValueChange = { viewModel.setEmailOrUsername(it) },
            label = {
                Text(text = "Email") // TODO
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 10.dp),
            value = password,
            onValueChange = { viewModel.setPassword(it) },
            label = {
                Text(text = "Password") // TODO
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide() // TODO Check when Compose BOM upgraded
                    viewModel.signIn()
                }
            ),
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(70.dp)
                .padding(vertical = 10.dp),
            onClick = {
                keyboardController?.hide()
                viewModel.signIn()
            },
            enabled = !signInLoading
        ) {
            if (signInLoading)
                CircularProgressIndicator(
                    modifier = Modifier.size(30.dp)
                )
            else
                Text(text = "Sign In") // TODO
        }
    }
}
