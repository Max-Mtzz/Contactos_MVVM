package com.example.contactos_mvvm.ui.components.dinamiclists

import android.service.controls.actions.ControlAction
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contactos_mvvm.data.model.Contacto

@Composable
fun DynamicUserList(
    items: List<Contacto>,
    onItemClick: (Contacto) -> Unit // <-- 1. ACEPTA UNA ACCIÓN POR USUARIO (Tambien manda al usuario a la acción)
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = items, key = { it.id }) { item ->
            UserCard(
                item = item,
                onClick = { onItemClick(item) } // <-- 2. PASA LA ACCIÓN AL ELEMENTO UserCard
            )
        }
    }
}