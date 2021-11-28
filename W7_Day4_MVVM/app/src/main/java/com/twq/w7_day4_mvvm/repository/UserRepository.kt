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

    fun login(username:String,password:String):LiveData<User>{
        var mliveData=MutableLiveData<User>()

        var userService=Api.getInstance().create(UserService::class.java)

        userService.getUserByUsernameAndPassword(username,password)
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    var listOFusers=response.body()
                    if (listOFusers?.isNotEmpty() == true){
                        mliveData.postValue(listOFusers[0])
                    }else{

                        mliveData.postValue(User("","","","",""))
                    }

                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })


      return mliveData
    }
}