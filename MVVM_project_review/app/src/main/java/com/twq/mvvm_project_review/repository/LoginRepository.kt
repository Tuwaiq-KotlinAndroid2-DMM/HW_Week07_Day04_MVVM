package com.twq.mvvm_project_review.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.mvvm_project_review.model.User
import com.twq.mvvm_project_review.network.Api
import com.twq.mvvm_project_review.network.LoginServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {


    fun login(username: String, password: String): LiveData<User> {
        val mutableLiveData = MutableLiveData<User>()
        val userServices = Api.getInstance().create(LoginServices::class.java)

        userServices.getUserByUsernameAndPassword(username, password)
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    var listOfUsers = response.body()
                    if (listOfUsers?.isNotEmpty() == true) {
                        mutableLiveData.postValue(listOfUsers[0])
                    }
                    //else {
//                        mutableLiveData.postValue(User("","","","",""))
//                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {

                }

            })

        return mutableLiveData
    }



}