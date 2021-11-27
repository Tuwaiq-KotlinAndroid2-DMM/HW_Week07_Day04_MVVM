package com.example.hw_w7_d4.network

import com.example.hw_w7_d4.model.User
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {

    @GET("User")
    fun getAllUsers():Call<List<User>>
}