package com.example.contactos_mvvm.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.contactos_mvvm.ui.components.ContactosList
import com.example.contactos_mvvm.ui.components.buttons.AddButton
import com.example.contactos_mvvm.ui.components.texts.Label
import com.example.contactos_mvvm.ui.components.texts.Title
import com.example.contactos_mvvm.viewmodel.ContactosViewModel

@Composable
fun ContactosScreen(viewModel: ContactosViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        // 🔹 Fila con el título a la izquierda y el botón a la derecha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title("Contactos")
            AddButton("Añadir") {
                navController.navigate("datos")
            }
        }

        val contactos by viewModel.contactos.collectAsStateWithLifecycle()

        ContactosList(contactos) { contact ->
            viewModel.clickContacto(contact)
            navController.navigate("datos")
        }

        Label("Fin de los contactos")
    }
}
