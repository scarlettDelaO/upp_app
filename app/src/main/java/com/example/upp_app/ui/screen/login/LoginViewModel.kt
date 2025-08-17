package com.example.upp_app.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upp_app.data.model.LoginRequest
import com.example.upp_app.data.model.LoginResponse
import com.example.upp_app.data.network.RetrofitClient
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf

class LoginViewModel : ViewModel() {
    val loginResult = mutableStateOf<LoginResponse?>(null)
    val errorMessage = mutableStateOf<String?>(null)

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {

                val response = RetrofitClient.api.login(LoginRequest(email, password))
                if (response.isSuccessful) {
                    loginResult.value = response.body()
                } else {
                    errorMessage.value = "Incorrect Credentials"
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
            }
        }
    }
}