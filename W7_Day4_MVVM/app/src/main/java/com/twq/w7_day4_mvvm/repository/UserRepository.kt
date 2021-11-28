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

    fun Registeration(username:String,email:String,password:String): LiveData<User> {
        var mLiveDatatReg= MutableLiveData<User>()

        var userService = Api.getInstance().create(UserService::class.java)
        userService.addUser(username,email,password)
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {

                    var listOFusers=response.body()
                    if (listOFusers?.id?.equals(true) ?: (true == null)
                    ){
                        mLiveDatatReg.postValue(listOFusers!!)
                    }else{

                        mLiveDatatReg.postValue(User("","","","",""))
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        return mLiveDatatReg
    }

    fun getAllUsers(): MutableLiveData<List<User>>{

        var mLiveDatauser = MutableLiveData<List<User>>()

        val userService = Api.getInstance().create(UserService::class.java)
        val usersList = userService.getAllUsers()
            .enqueue(object : Callback<List<User>>{
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    mLiveDatauser.postValue(response.body())
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        return mLiveDatauser
    }

}