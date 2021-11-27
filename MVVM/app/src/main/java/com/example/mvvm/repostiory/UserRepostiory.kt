package com.example.mvvm.repostiory

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.model.User
import com.example.mvvm.network.API
import com.example.mvvm.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepostiory {

    var userService = API.getInstence().create(UserService::class.java)

    fun login(username: String, password: String): LiveData<User> {
        var mLiveData = MutableLiveData<User>()


        userService.getUserByusernameAndPassword(username, password)
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    var listOfusers = response.body()
                    if (listOfusers?.isNotEmpty() == true) {
                        mLiveData.postValue(listOfusers[0])
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


    fun register(
        username: String, password: String, email: String, avatar: String): LiveData<User> {
        var mLiveData = MutableLiveData<User>()
        userService.signUp(User(email, "1", password, avatar, username))
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        mLiveData.postValue(response.body())
                    } else {
                        mLiveData.postValue(User("", "", "", "", ""))
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        return mLiveData
    }


    fun getAllUser(): MutableLiveData<List<User>> {

        var mutableLiveData = MutableLiveData<List<User>>()

        userService.getAllUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


        return mutableLiveData
    }
}