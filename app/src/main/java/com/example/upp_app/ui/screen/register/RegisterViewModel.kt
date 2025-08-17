package com.example.upp_app.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upp_app.data.model.RegisterRequest
import com.example.upp_app.data.network.RetrofitClient
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf


class RegisterViewModel : ViewModel() {
    val registerResult = mutableStateOf<Boolean?>(null)
    val registerError = mutableStateOf<String?>(null)

    fun register(name: String, email: String, password: String) {
        val request = RegisterRequest(name, email, password,password_confirmation = password)

        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.register(request)
                if (response.isSuccessful) {
                    registerResult.value = true
                } else {
                    registerError.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                registerError.value = "Excepción: ${e.message}"
            }
        }
    }
}