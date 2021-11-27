package com.example.usingmvvm.network

import com.example.usingmvvm.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("User")
    fun getUserByUSernameAndPassword(@Query("username")username:String, @Query("password")password:String): Call<List<User>>

    @GET("User")
    fun getUserDetails(): Call<List<User>>

    @POST("User")
    fun addUser(@Body user:User): Call<User>

}