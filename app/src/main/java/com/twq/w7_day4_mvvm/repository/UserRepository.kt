package com.twq.w7_day4_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.network.API
import com.twq.w7_day4_mvvm.network.UserService
import java.lang.reflect.Array.get
import java.util.Calendar.getInstance
import java.util.Currency.getInstance

class UserRepository {

    fun login(username:String,password:String):LiveData<User>{
        var mutableLiveData=MutableLiveData<User>()

        var userservice= API.getInstance().create(UserService::class.java)

        userservice.
    }
}