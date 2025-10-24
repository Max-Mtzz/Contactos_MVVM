package com.example.contactos_mvvm.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactos_mvvm.ui.screens.ContactosScreen
import com.example.contactos_mvvm.ui.screens.DatosScreen
import com.example.contactos_mvvm.ui.screens.ForgotPasswordScreen
import com.example.contactos_mvvm.ui.screens.LoginScreen
import com.example.contactos_mvvm.ui.screens.RegisterScreen
import com.example.contactos_mvvm.viewmodel.ContactosViewModel
import com.example.contactos_mvvm.viewmodel.LoginViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel: ContactosViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") { ForgotPasswordScreen(navController) }
        composable("register") { RegisterScreen(navController) }

        composable("verContactos") {
            ContactosScreen(viewModel, navController)
        }
        composable("datos") {
            DatosScreen(viewModel, navController)
        }
    }

}