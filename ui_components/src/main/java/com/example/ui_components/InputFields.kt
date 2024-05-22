package com.example.ui_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.ui_components.theme.Blue
import com.example.ui_components.theme.BlueGray
import com.example.ui_components.theme.BlueLight
import com.example.ui_components.theme.White

@Composable
fun BaseInputField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    singleLine: Boolean = true,
    keyBoardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Next,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
            imeAction = imeAction,
        ),
        keyboardActions = keyboardActions,
        enabled = enabled,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = BlueGray,
            unfocusedLabelColor = BlueGray,
            focusedBorderColor = BlueLight,
            focusedLabelColor = BlueLight,
            cursorColor = BlueLight,
            selectionColors = TextSelectionColors(BlueLight, Blue)
        ),
        shape = CircleShape.copy(CornerSize(15.dp))
    )
}

@Composable
fun EmailInputField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Next,
    enabled: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    BaseInputField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = stringResource(id = R.string.email_label),
        imeAction = imeAction,
        enabled = enabled,
        keyBoardType = KeyboardType.Email,
        keyboardActions = keyboardActions,
    )
}

@Composable
fun PasswordInputField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Done,
    enabled: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    val visualTransformation = remember {
        mutableStateOf<VisualTransformation>(PasswordVisualTransformation())
    }
    val showPassword = remember { mutableStateOf(false) }
    BaseInputField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = stringResource(id = R.string.password_label),
        imeAction = imeAction,
        enabled = enabled,
        visualTransformation = visualTransformation.value,
        keyBoardType = KeyboardType.Password,
        keyboardActions = keyboardActions,
    ) {
        val drawable =
            if (showPassword.value) R.drawable.password_eye
            else R.drawable.password_eye_closed
        val contentDescription =
            if (showPassword.value) "Hide Password"
            else "Show Password"

        Icon(
            modifier = Modifier
                .size(26.dp)
                .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                    showPassword.value = !showPassword.value
                    if (showPassword.value) visualTransformation.value = VisualTransformation.None
                    else visualTransformation.value = PasswordVisualTransformation()
                },
            painter = painterResource(drawable),
            contentDescription = contentDescription,
            tint = White.copy(alpha = 0.8f)
        )
    }
}
