package com.example.contactos_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactos_mvvm.data.model.Contacto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DynamicUserListViewModel : ViewModel() {

    // 1. ESTADO: Privado y mutable para el ViewModel, similar a mutableState pero para viewModel
    private val _items = MutableStateFlow<List<Contacto>>(emptyList())

    // 2. DATOS: Público e inmutable para la UI, similar a mutableState pero para viewModel
    val items: StateFlow<List<Contacto>> = _items

    init {
        // Carga los datos iniciales cuando se crea el ViewModel
        //Este metodo se ejecuta cuando se manda a llamar el viewModel por primera vez
        // Es importante para siguientes temas de conección a BD
        loadItems()
    }

    // 3. EVENTO: Función pública para que la UI notifique una acción
    fun onItemClicked(item: Contacto) {
        // --- AQUÍ VA LA LÓGICA DE NEGOCIO ---
        // Por ejemplo:
        // - Navegar a otra pantalla
        // - Marcar el elemento como seleccionado
        // - Realizar una llamada a la API
        // - Actualizar el estado
        // En este caso solo mostramos un mensaje en el LogCat:
        println("ViewModel ha sido notificado del clic en: ${item.nombre}")
    }

    private fun loadItems() {
        // Aquí cargarías los datos desde un repositorio (base de datos, API, etc.)
        // Por ahora, usamos datos de ejemplo.
    }
}