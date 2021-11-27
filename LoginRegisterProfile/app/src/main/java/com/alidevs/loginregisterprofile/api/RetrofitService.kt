package com.alidevs.loginregisterprofile.api

import com.alidevs.loginregisterprofile.model.UserModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {

	// User login
	@GET("User")
	suspend fun getUser(@Query("email") email: String): Response<List<UserModel>>

	// User register
	@POST("User")
	suspend fun createUser(
		@Body user: UserModel
	): Response<UserModel>

	// User list
	@GET("User")
	suspend fun getAllUsers(): Response<List<UserModel>>

	companion object {
		var instance: RetrofitService? = null
			private set
			get() {
				if (field == null) {
					field = Retrofit.Builder()
						.baseUrl("https://618ebc2e50e24d0017ce141f.mockapi.io/")
						.addConverterFactory(GsonConverterFactory.create())
						.build()
						.create(RetrofitService::class.java)
				}

				return field
			}
	}

}