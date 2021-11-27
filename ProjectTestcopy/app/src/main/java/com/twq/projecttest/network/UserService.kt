package com.twq.projecttest.network

import com.twq.projecttest.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("User")
    fun getUserByUsernameAndPassword(@Query ("username")username:String,
                                     @Query("password")password:String): Call<List<User>>

    @GET("User")
    fun getAllUsers(): Call<List<User>>

    @POST("User")
    fun addUser(@Body user: User):Call<User>

    @GET("User/{username}")
    fun getUserData(@Path("username")username:String): Call<User>

}