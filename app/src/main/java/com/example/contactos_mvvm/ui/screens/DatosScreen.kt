package com.example.contactos_mvvm.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.contactos_mvvm.ui.components.DatosCard
import com.example.contactos_mvvm.viewmodel.ContactosViewModel

@Composable
fun DatosScreen(viewModel: ContactosViewModel, navController: NavController) {
    val contactState by viewModel.selectedContact.collectAsStateWithLifecycle()
    val contact = contactState // <- variable local para smart cast

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(33.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Regresar"
                )
            }
        }

        if (contact != null && contact.nombre.isNotEmpty()) {
            DatosCard(contact)
        } else if (contact == null) {
            Text(
                text = "Error: No se seleccionó ningún contacto.",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            Text(
                text = "Este contacto no tiene datos.",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
