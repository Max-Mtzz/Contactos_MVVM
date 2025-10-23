package com.example.contactos_mvvm.ui.components.inputs

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun PasswordField(viewModel: LoginViewModel, label: String = "Contraseña") {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = viewModel.password.value,
        onValueChange = { viewModel.password.value = it },
