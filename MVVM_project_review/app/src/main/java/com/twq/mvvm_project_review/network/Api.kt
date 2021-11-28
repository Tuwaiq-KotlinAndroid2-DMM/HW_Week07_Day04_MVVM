package com.twq.mvvm_project_review.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    companion object{
        private  val retrofit:Retrofit
        init {
            retrofit= Retrofit.Builder()
                .baseUrl("https://618ebc2e50e24d0017ce141f.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getInstance(): Retrofit {
            return retrofit
        }



    }
}