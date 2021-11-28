package com.twq.w7_day4_mvvm.network

import android.telecom.Call
import com.twq.w7_day4_mvvm.model.User
import retrofit2.http.GET

interface HomeService {

    @GET("User")
    fun getAllUsers(): Call<List<User>>

}