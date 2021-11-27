package com.twq.w7_day4_mvvm.network

import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("User")
    getUserByUsernameAbdPassword(@Query("username")username:String,@Query("password")password:String)
}