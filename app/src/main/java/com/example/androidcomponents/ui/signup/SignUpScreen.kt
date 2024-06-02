package com.example.androidcomponents.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ui_components.BaseInputField
import com.example.ui_components.EmailInputField
import com.example.ui_components.PasswordInputField
import com.example.ui_components.PrimaryButton
import com.example.ui_components.SecondaryButton
import com.example.ui_components.animated.backgroundBrush
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpViewModel: SignUpViewModel = koinViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val firstName by signUpViewModel.firstName.collectAsState()
        val lastName by signUpViewModel.lastName.collectAsState()
        val email by signUpViewModel.email.collectAsState()
        val confirmedEmail by signUpViewModel.confirmedEmail.collectAsState()
        val password by signUpViewModel.password.collectAsState()
        val confirmedPassword by signUpViewModel.confirmedPassword.collectAsState()
        val signUpLoading by signUpViewModel.signUpLoading.collectAsState()

        Text(text = "Create your account")
        BaseInputField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 10.dp),
            value = firstName,
            onValueChange = { signUpViewModel.setFirstName(it) },
            label = "First Name" // TODO
        )
        BaseInputField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
            value = lastName,
            onValueChange = { signUpViewModel.setLastName(it) },
            label = "Last Name" // TODO
        )
        EmailInputField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
            value = email,
            onValueChange = { signUpViewModel.setEmail(it) }
        )
        EmailInputField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
            value = confirmedEmail,
            onValueChange = { signUpViewModel.setConfirmedEmail(it) }
        )
        PasswordInputField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
            value = password,
            onValueChange = { signUpViewModel.setPassword(it) }
        )
        PasswordInputField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
            value = confirmedPassword,
            onValueChange = { signUpViewModel.setConfirmedPassword(it) }
        )
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 20.dp, bottom = 10.dp)
                .height(45.dp),
            text = "Sign Up", // TODO
            isLoading = signUpLoading
        ) {
            signUpViewModel.signUp { navController.popBackStack() }
        }
        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(45.dp),
            text = "Back to Sign In" // TODO
        ) { navController.popBackStack() }
    }
}
