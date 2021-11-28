package com.twq.mvvm_project_review.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.mvvm_project_review.model.User
import com.twq.mvvm_project_review.network.Api
import com.twq.mvvm_project_review.network.HomeServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    fun getAllUser (): LiveData<List<User>>{
        val mLiveData = MutableLiveData<List<User>>()
        val homeServices = Api.getInstance().create(HomeServices::class.java)
        homeServices.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
               mLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }

        })

        return mLiveData
    }
}
