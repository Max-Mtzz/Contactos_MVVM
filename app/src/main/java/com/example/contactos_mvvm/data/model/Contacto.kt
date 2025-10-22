package com.example.contactos_mvvm.data.model

import androidx.annotation.DrawableRes

data class Contacto(
    val id: Int,
    @DrawableRes val imagen: Int,
    val nombre: String,
    val apellido: String,
    val telefono: String,
    val correo: String,
        )