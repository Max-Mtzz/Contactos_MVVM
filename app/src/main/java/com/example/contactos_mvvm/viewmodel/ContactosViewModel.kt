package com.example.contactos_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactos_mvvm.R
import com.example.contactos_mvvm.data.model.Contacto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContactosViewModel : ViewModel() {

    val _contactos = MutableStateFlow<List<Contacto>>(emptyList())
    val contactos : StateFlow<List<Contacto>> = _contactos
    private val _selectedContact = MutableStateFlow<Contacto?>(null)
    val selectedContact: StateFlow<Contacto?> = _selectedContact

    init {
        _contactos.value = listOf(
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
            ),
            Contacto(
                4,
                R.drawable.maleprofile,
                "Jorge",
                "Morales Cardenas",
                "7775550217",
                "jorge@gmail.com"
            ),
            Contacto(
                5,
                R.drawable.maleprofile,
                "Alejandro",
                "Rios Garcia",
                "7775550217",
                "ale@gmail.com"
            ),
            Contacto(
                6,
                R.drawable.maleprofile,
                "Murat",
                "Castro Alvarez",
                "7775550217",
                "murat@gmail.com"
            )
        )

    }

    fun clickContacto(contacto : Contacto){
        println("Haz hecho click en ${contacto.nombre}")
        _selectedContact.value = contacto
    }
}

