package com.example.contactos_mvvm.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.contactos_mvvm.ui.components.ContactosList
import com.example.contactos_mvvm.ui.components.texts.Label
import com.example.contactos_mvvm.ui.components.texts.Title

@Composable
fun ContactosScreen(viewModel: ViewModel, navController: NavController){
    Column {
        Title("Contactos")
        val contactos by viewModel.contactos.collectAsStateWithLifecycle()
        ContactosList(contactos) {viewModel:: clickContacto}
        Label("Fin de los contactos")
    }
}