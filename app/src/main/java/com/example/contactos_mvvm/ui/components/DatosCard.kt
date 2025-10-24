package com.example.contactos_mvvm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.contactos_mvvm.R
import com.example.contactos_mvvm.data.model.Contacto
import com.example.contactos_mvvm.ui.components.buttons.PrimaryButton
import com.example.contactos_mvvm.ui.components.buttons.SecondaryButton
import com.example.contactos_mvvm.ui.theme.Contactos_MVVMTheme

@Composable
fun DatosCard(datos: Contacto, navController: NavController){
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Imagen del contacto
            Image(
                painter = painterResource(id = datos.imagen),
                contentDescription = "Imagen del contacto",
                modifier = Modifier.size(100.dp)
            )

            // Campos (solo muestran el valor actual)
            OutlinedTextField(
                value = datos.nombre,
                onValueChange = {},
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = datos.apellido,
                onValueChange = {},
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = datos.telefono,
                onValueChange = {},
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            OutlinedTextField(
                value = datos.correo,
                onValueChange = {},
                label = { Text("Correo") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SecondaryButton("Cancelar") {
                    navController.popBackStack()
                }
                PrimaryButton("Guardar") { }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDatosCard(){
    val navController = androidx.navigation.compose.rememberNavController()
    val c = Contacto(
        1,
        R.drawable.maleprofile,
        "Samuel",
        "Rivera Robles",
        "7775550217",
        "samuel@gmail.com"
    )

    Contactos_MVVMTheme {
        DatosCard(datos = c, navController = navController)
    }
}