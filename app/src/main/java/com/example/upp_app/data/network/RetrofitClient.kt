package com.example.upp_app.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //RUTA QUE COMPARTE LA COMPUTADORA Y EL CELULAR
    //private const val BASE_URL = "http://192.168.0.63:8000/api/"

    //RUTA PARA PRESENTACION
    private const val BASE_URL = "http://10.0.19.148:8000/api/"

    //RUTA DE MI CASA
    //private const val BASE_URL = "http://192.168.1.77:8000/api/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}