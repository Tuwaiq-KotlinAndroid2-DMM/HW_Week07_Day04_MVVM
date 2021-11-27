package com.example.mvvm.network

import androidx.room.Insert
import com.example.mvvm.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @GET("User")
    fun getUserByusernameAndPassword(@Query("username")username:String,@Query("password") password:String): Call<List<User>>

    @POST("User")
    fun signUp(@Body user:User):Call<User>

    @GET("User")
    fun getAllUser():Call<List<User>>




}