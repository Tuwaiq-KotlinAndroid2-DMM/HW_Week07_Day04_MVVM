package com.example.day34practicemvvmproject.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    companion object {
        var BASE_URL = "https://618ebc2e50e24d0017ce141f.mockapi.io/"

        private val retrofit: Retrofit
        init {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build()
        }

        fun getInstance() = retrofit
    }

}