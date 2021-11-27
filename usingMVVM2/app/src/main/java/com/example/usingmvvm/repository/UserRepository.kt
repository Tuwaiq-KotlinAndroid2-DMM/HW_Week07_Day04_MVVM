package com.example.usingmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.usingmvvm.model.User
import com.example.usingmvvm.network.UserService
import retrofit2.Call
import retrofit2.Response

class UserRepository {

    fun login(username:String,password:String): LiveData<User>{

        var mLivedata = MutableLiveData<User>()

        //call service using retroift
        val userService = com.example.usingmvvm.network.Api.getInstance().create(UserService::class.java)
        userService.getUserByUSernameAndPassword(username,password)
            .enqueue(object: retrofit2.Callback<List<User>>{
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    var listOfUsers = response.body()
                    if(listOfUsers?.isNotEmpty() == true){
                        mLivedata.postValue(listOfUsers[0])
                    }else{
                        mLivedata.postValue(User("","",password,"",username))
                        //mLivedata.postValue(response.body())

                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {

                }

            })
        return mLivedata
    }

    fun getuserdata():MutableLiveData<List<User>>{
        var mLivedata = MutableLiveData<List<User>>()

        //call service using retroift
        val userService = com.example.usingmvvm.network.Api.getInstance().create(UserService::class.java)
        userService.getUserDetails()
            .enqueue(object: retrofit2.Callback<List<User>>{

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    mLivedata.postValue(response.body())
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                }

            })
        return mLivedata

    }


    fun Registeration(username: String,email:String,password: String): LiveData<User>{
        var mLivedata = MutableLiveData<User>()

        val userService = com.example.usingmvvm.network.Api.getInstance().create(UserService::class.java)
        userService.addUser(User(email,"",password,"",username))
            .enqueue(object: retrofit2.Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        mLivedata.postValue(response.body())
                    }else{
                        mLivedata.postValue(User("","","","",""))
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                }

    })
        return mLivedata
}
}