package com.twq.mvvm_project_review.network

import com.twq.mvvm_project_review.model.User
import retrofit2.Call
import retrofit2.http.GET

interface HomeServices {
    @GET("User")
    fun getAllUsers ():Call<List<User>>
}
