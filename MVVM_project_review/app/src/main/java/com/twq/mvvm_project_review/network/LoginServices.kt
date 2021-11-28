package com.twq.mvvm_project_review.network

import com.twq.mvvm_project_review.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginServices {

    @GET("User")
    fun getUserByUsernameAndPassword(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<List<User>>

}