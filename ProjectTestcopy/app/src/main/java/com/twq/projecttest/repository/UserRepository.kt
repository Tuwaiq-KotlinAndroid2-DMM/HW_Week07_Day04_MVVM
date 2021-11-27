package com.twq.projecttest.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twq.projecttest.R
import com.twq.projecttest.model.User
import com.twq.projecttest.model.UserAdapter
import com.twq.projecttest.network.Api
import com.twq.projecttest.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    var userService = Api.getInstance().create(UserService::class.java)

    fun login (username:String,password:String):LiveData<User>{
        var mLiveData = MutableLiveData<User>()
        userService.getUserByUsernameAndPassword(username,password).enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                var listOfUsers = response.body()
                if (listOfUsers?.isNotEmpty() == true){
                    mLiveData.postValue(listOfUsers[0])
                }else{
                    mLiveData.postValue(User("","","","", ""))
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("Doc Snippet", "Failed to get login")
            }

        })
        return mLiveData
    }

    fun register (username: String,password: String):LiveData<User>{
        var user = User("Aliboholaiqa@gmail.com","",password,"https://www.vhv.rs/dpng/d/267-2676989_annoyed-peter-father-of-family-guy-hd-png.png",username)
        var mLiveData = MutableLiveData<User>()
        userService.addUser(user).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    var newUser = response.body()
                    mLiveData.postValue(newUser!!)
                    Log.d("Doc Snippet", "New user added")
                }else{
                    mLiveData.postValue(User("","","","", ""))
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("Doc Snippet", "Failed to add a user")
            }


        })
        return mLiveData
    }
    fun users():MutableLiveData<List<User>>{
        var mLiveData = MutableLiveData<List<User>>()
        userService.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                var list = response.body()
                mLiveData.postValue(list!!)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("Doc Snippet", "Failed to get user")

            }

        })
    return mLiveData
    }

    fun profile(username:String):MutableLiveData<User>{
        var mLiveData = MutableLiveData<User>()
        userService.getUserData(username).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                var listOfUsers = response.body()
                mLiveData.postValue(User("","","","",""))
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })
        return mLiveData

    }

}