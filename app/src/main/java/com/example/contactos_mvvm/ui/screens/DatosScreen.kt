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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.contactos_mvvm.R
import com.example.contactos_mvvm.data.model.Contacto
import com.example.contactos_mvvm.ui.components.DatosCard
import com.example.contactos_mvvm.viewmodel.ContactosViewModel

@Composable
fun DatosScreen(viewModel: ContactosViewModel, navController: NavController) {
    val contactState by viewModel.selectedContact.collectAsStateWithLifecycle()

    // 👇 Si el contacto es nulo, creamos uno vacío (no nullable)
    val contact: Contacto = contactState ?: Contacto(
        id = -1,
        imagen = R.drawable.maleprofile,
        nombre = "",
        apellido = "",
        telefono = "",
        correo = ""
    )

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

        // ✅ Ahora siempre es un Contacto no nulo
        DatosCard(contact, navController)
    }
}
