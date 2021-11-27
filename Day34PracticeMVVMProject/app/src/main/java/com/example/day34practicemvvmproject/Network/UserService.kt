package com.example.day34practicemvvmproject.Network

import com.example.day34practicemvvmproject.Model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("User")
    fun getUserByUsernameAndPassword(
        @Query("username")username: String
    ): Call<List<User>>

    @POST("User")
    fun addNewUser(@Body user: User): Call<User>

    @GET("User")
    fun getAllUser(): Call<List<User>>

}