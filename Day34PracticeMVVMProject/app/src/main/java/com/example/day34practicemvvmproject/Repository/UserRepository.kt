package com.example.day34practicemvvmproject.Repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.day34practicemvvmproject.Model.User
import com.example.day34practicemvvmproject.Network.Api
import com.example.day34practicemvvmproject.Network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun getUser(username: String, password: String): LiveData<User> {
        val livedata = MutableLiveData<User>()

        Api.getInstance().create(UserService::class.java).getUserByUsernameAndPassword(username)
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?){
                    Log.d(TAG, "onResponse: ${response?.message()}")
                    if (response?.body() != null) {
                        val users = response?.body()!!
                        if (users[0].id.length != 0) {
                            livedata.postValue(users[0])
                        } else {
                            livedata.postValue(User("","","","",""))
                        }
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })
        return livedata
    }

    fun addUser(user: User): LiveData<User>{
        val livedata = MutableLiveData<User>()

        Api.getInstance().create(UserService::class.java).addNewUser(user)
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    Log.d(TAG, "onResponse: ${response?.message()}")
                    if (response?.body() != null) {
                        val data = response?.body()!!
                        if (data.id.length != 0){
                            livedata.postValue(data)
                        }else {
                            livedata.postValue(User("","","","",""))
                        }
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }

            })


        return livedata
    }

    fun getAllUsers(): LiveData<List<User>>{
        val livedata = MutableLiveData<List<User>>()

        Api.getInstance().create(UserService::class.java).getAllUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response?.body() != null) {
                    val users = response?.body()!!
                    livedata.postValue(users)
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        return livedata
    }

}