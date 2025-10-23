package com.example.contactos_mvvm.ui.components.inputs

import androidx.compose.runtime.Composable

@Composable
fun UserInputField(
    viewModel: LoginViewModel,
    label: String = "Usuario",
    onNext: (() -> Unit)? = null
)

