package com.twq.mvvm_project_review.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.mvvm_project_review.model.User
import com.twq.mvvm_project_review.network.Api
import com.twq.mvvm_project_review.network.LoginServices
import com.twq.mvvm_project_review.network.RegisterServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterRepository {
    fun addUser(
        id: String? = "1", username: String, email: String, password: String,
        imgUrl: String? = "no picture"
    ): LiveData<User> {
        val mLiveData = MutableLiveData<User>()
        val userServices = Api.getInstance().create(RegisterServices::class.java)
        userServices.addUser(User(email, null, password, null, username))
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    mLiveData.postValue(response.body())
                    Log.d("ADD_FAILED", "you ${response.body()}")
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("ADD_FAILED", "failed: ${t.message}")
                }

            })


        return mLiveData
    }
}