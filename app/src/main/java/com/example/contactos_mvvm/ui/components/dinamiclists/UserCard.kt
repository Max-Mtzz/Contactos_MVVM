package com.example.contactos_mvvm.ui.components.dinamiclists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactos_mvvm.data.model.Contacto



@Composable
fun UserCard(
    item: Contacto,
    onClick: () -> Unit // <-- 1. ACEPTA UNA FUNCIÓN DE CLIC
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "$item.id",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.nombre,
                fontSize = 14.sp
            )
        }
    }
}