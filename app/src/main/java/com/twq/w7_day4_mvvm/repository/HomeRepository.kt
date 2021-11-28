package com.twq.w7_day4_mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.network.Api
import com.twq.w7_day4_mvvm.network.HomeService
import okhttp3.Call
import okhttp3.Response
import javax.security.auth.callback.Callback

class HomeRepository {

    fun getAllUser() : MutableLiveData<List<User>> {

        var userList =MutableLiveData<List<User>>()
        val homeService= Api.getInstance().create(HomeService::class.java)
        val callUserList =homeService.getAllUsers()
        callUserList.enqueue(object : Callback<List<User>> {
            fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                userList.postValue(response.body())            }

            fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return userList






    }

}
