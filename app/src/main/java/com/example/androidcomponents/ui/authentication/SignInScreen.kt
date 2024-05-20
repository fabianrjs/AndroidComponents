package com.example.androidcomponents.ui.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidcomponents.R
import com.example.androidcomponents.navhost.AppRoutes
import com.example.ui_components.PrimaryButton
import com.example.ui_components.SecondaryButton
import com.example.ui_components.animated.backgroundBrush
import com.example.ui_components.theme.BlueLight
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    viewModel: AuthViewModel = koinViewModel(),
    navController: NavController
) {
    val emailOrUsername by viewModel.emailOrUsername.collectAsState()
    val password by viewModel.password.collectAsState()
    val signInLoading by viewModel.signInLoading.collectAsState()

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = stringResource(id = R.string.sign_in_welcome_text),
            textAlign = TextAlign.Center,
            color = BlueLight
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 10.dp),
            value = emailOrUsername,
            onValueChange = { viewModel.setEmailOrUsername(it) },
            label = {
                Text(text = stringResource(id = R.string.email_text))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            value = password,
            onValueChange = { viewModel.setPassword(it) },
            label = {
                Text(text = stringResource(id = R.string.password_text))
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    viewModel.signIn { navController.navigate(AppRoutes.HomeScreen.route) }
                }
            ),
        )
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp, top = 20.dp)
                .height(45.dp),
            text = stringResource(id = R.string.sign_in_text),
            isLoading = signInLoading,
        ) {
            keyboardController?.hide()
            viewModel.signIn { navController.navigate(AppRoutes.HomeScreen.route) }
        }
        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(45.dp),
            text = stringResource(id = R.string.sign_up_text),
            enabled = !signInLoading,
        ) {
            navController.navigate(AppRoutes.SingUpScreen.route)
        }
    }
}
