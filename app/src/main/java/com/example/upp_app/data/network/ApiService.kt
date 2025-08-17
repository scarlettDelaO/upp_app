package com.example.upp_app.data.network

import com.example.upp_app.data.model.LoginRequest
import com.example.upp_app.data.model.LoginResponse
import com.example.upp_app.data.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<Unit>
}
