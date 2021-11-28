package com.twq.w7_day4_mvvm.view.registeration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.network.Api
import com.twq.w7_day4_mvvm.network.UserService
import com.twq.w7_day4_mvvm.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterationViewModel: ViewModel() {

    fun registertions(username:String,password:String,email:String): LiveData<Boolean>{
        var mLiveData=MutableLiveData<Boolean>()

        UserRepository().Registeration(username,email, password).observeForever {

            if(it.username.isNotEmpty() && it.email.isNotEmpty() && it.password.isNotEmpty())
                mLiveData.postValue(true)
            else
                mLiveData.postValue(false)

        }


        return  mLiveData
    }


}