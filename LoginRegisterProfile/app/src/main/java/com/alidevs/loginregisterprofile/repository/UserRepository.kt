package com.alidevs.loginregisterprofile.repository

import com.alidevs.loginregisterprofile.api.RetrofitService
import com.alidevs.loginregisterprofile.model.UserModel

class UserRepository {

	private val retrofitService = RetrofitService.instance!!

	suspend fun getUser(email: String) = retrofitService.getUser(email)

	suspend fun getAllUsers() = retrofitService.getAllUsers()

	suspend fun createUser(userModel: UserModel)  = retrofitService.createUser(userModel)

}