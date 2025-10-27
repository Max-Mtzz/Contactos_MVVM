package com.example.contactos_mvvm.viewmodel

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ForgotPasswordViewModel : ViewModel(){


    class ForgotPasswordViewModel : ViewModel() {

        private val _email = MutableStateFlow("")
        val email: StateFlow<String> = _email

        private val _emailSent = MutableStateFlow<Boolean?>(null)
        val emailSent: StateFlow<Boolean?> = _emailSent

        // Actualiza el valor del campo de correo
        fun onEmailChange(newValue: String) {
            _email.value = newValue
        }

        // Simula el envío del correo de recuperación
        fun sendRecoveryEmail() {
            if (_email.value.isNotBlank()) {
                // Aquí se llamaría a una API real
                _emailSent.value = true
            } else {
                _emailSent.value = false
            }
        }
    }


}