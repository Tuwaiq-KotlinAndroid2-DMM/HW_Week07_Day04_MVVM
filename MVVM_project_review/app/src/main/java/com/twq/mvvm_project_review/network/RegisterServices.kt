package com.twq.mvvm_project_review.network

import com.twq.mvvm_project_review.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterServices {

    @POST("User")
    fun addUser(@Body user: User): Call<User>
}