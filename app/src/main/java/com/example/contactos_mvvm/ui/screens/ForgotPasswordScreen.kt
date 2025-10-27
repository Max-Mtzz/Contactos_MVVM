package com.example.contactos_mvvm.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.contactos_mvvm.ui.components.buttons.PrimaryButton
import com.example.contactos_mvvm.ui.theme.Contactos_MVVMTheme
import com.example.contactos_mvvm.viewmodel.ForgotPasswordViewModel
import com.example.contactos_mvvm.viewmodel.LoginViewModel


@Composable
fun ForgotPasswordScreen(viewModel: ForgotPasswordViewModel, navController: NavController) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título
        Text(
            text = "Recupera tu cuenta",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Campo de texto
        Text(text = "Ingresa tu correo")
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = { Text("ejemplo@correo.com") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de enviar
        PrimaryButton(text = "Enviar") {
            // Aquí iría la lógica de recuperación
        }
    }

    // Botón "Atrás" anclado en la parte inferior
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        PrimaryButton(text = "Atrás") {
            navController?.popBackStack()
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    Contactos_MVVMTheme {
        val navController = rememberNavController()
        val viewModel = ForgotPasswordViewModel()

        ForgotPasswordScreen(
            navController = navController,
            viewModel = viewModel
        )
    }
}
