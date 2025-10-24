package com.example.contactos_mvvm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactos_mvvm.R
import com.example.contactos_mvvm.data.model.Contacto
import com.example.contactos_mvvm.ui.components.buttons.PrimaryButton
import com.example.contactos_mvvm.ui.components.buttons.SecondaryButton
import com.example.contactos_mvvm.ui.theme.Contactos_MVVMTheme

@Composable
fun ContactosCard(c: Contacto, x: (Contacto) -> Unit){
    Column{
        Card (modifier = Modifier.clickable{x(c)}
            .fillMaxWidth()){
            Row (verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(R.drawable.contacto__1_),
                    contentDescription = "imagen del contacto",
                    modifier = Modifier.width(40.dp)
                )
                Column {
                    Text(text = c.nombre, modifier = Modifier.padding(10.dp))
                }
            }
            Row {
                Column{
                    PrimaryButton("Editar") { }
                }
                Column {
                    SecondaryButton("Eliminar") { }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContactosCard(){
    val c = Contacto(
        1,
        R.drawable.maleprofile,
        "Samuel",
        "Rivera Robles",
        "7775550217",
        "samuel@gmail.com"
    )
    Contactos_MVVMTheme {
        ContactosCard(c) { }
    }
}