package com.tuwaq.hww7d4.network


import com.tuwaq.hww7d4.model.User
import retrofit2.Call
import retrofit2.http.GET
interface HomeService {

    @GET("User")
    fun getAllUsers():Call<List<User>>
}