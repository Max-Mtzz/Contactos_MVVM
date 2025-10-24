package com.example.contactos_mvvm.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactos_mvvm.R
import com.example.contactos_mvvm.data.model.Contacto
import com.example.contactos_mvvm.ui.theme.Contactos_MVVMTheme

@Composable
fun ContactosList(lista: List<Contacto>, x: (Contacto) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = lista, key = { it.id }) { contactos ->
            ContactosCard(contactos) { x(contactos) }
        }
    }
}

@Preview
@Composable
fun PreviewContactoList(){
    val lista = listOf(
        Contacto(
            1,
            R.drawable.maleprofile,
            "Samuel",
            "Rivera Robles",
            "7775550217",
            "samuel@gmail.com"
        ),
        Contacto(
            2,
            R.drawable.femaleprofile,
            "Sylvanna",
            "Cisneros Zaragoza",
            "7775550217",
            "syyl@gmail.com"
        ),
        Contacto(
            3,
            R.drawable.maleprofile,
            "Diego",
            "Salazar Maya",
            "7775550217",
            "diego@gmail.com"
        )
    )
    Contactos_MVVMTheme {
        ContactosList(lista) { }
    }
}