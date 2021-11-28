package com.tuwaq.hww7d4.repository

import androidx.lifecycle.MutableLiveData
import com.tuwaq.hww7d4.model.User
import com.tuwaq.hww7d4.network.API
import com.tuwaq.hww7d4.network.HomeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    fun getAllUser() :MutableLiveData<List<User>>{

        var userList =MutableLiveData<List<User>>()
        val homeService= API.getInstance().create(HomeService::class.java)
        val callUserList =homeService.getAllUsers()
        callUserList.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                userList.postValue(response.body())            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return userList






    }

}