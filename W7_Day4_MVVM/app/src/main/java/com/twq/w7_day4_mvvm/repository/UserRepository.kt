package com.twq.w7_day4_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.network.Api
import com.twq.w7_day4_mvvm.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {

    var userService = Api.getInstance().create(UserService::class.java)
    var mLiveData = MutableLiveData<User>()

    fun login(username: String, password: String): LiveData<User> {
        userService.getUserByUsernameAndPassword(username, password)
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    val listOFusers = response.body()
                    if (listOFusers?.isNotEmpty() == true) {
                        mLiveData.postValue(listOFusers[0])
                    } else {
                        mLiveData.postValue(User("", "", "", "", ""))
                    }
                }
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        return mLiveData
    }
    fun getAllUsers(): MutableLiveData<List<User>> {
        var mutableLiveData = MutableLiveData<List<User>>()
        val callUserList = userService.getAllUsers()
        callUserList.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
            }

        })
        return mutableLiveData
    }

    fun getSelectedUser(id:Int): LiveData<User> {
        userService.getSelectedUser(id)
            .enqueue(object :Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    var profile=response.body()
                    mLiveData.postValue(profile!!)
                }
                override fun onFailure(call: Call<User>, t: Throwable) {
                }
            })
return mLiveData
    }
}
