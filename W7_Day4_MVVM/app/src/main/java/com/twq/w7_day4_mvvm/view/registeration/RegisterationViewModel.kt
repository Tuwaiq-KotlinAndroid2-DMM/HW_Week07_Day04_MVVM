package com.twq.w7_day4_mvvm.view.registeration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.w7_day4_mvvm.repository.UserRepository

class RegisterViewModel:ViewModel() {

    fun register(email: String, password: String, username: String): LiveData<Boolean>{
        var mLiveData = MutableLiveData<Boolean>()

        UserRepository().register(email,password,username).observeForever {
            if(it.username.isNotEmpty() && it.email.isNotEmpty() && it.password.isNotEmpty())
                mLiveData.postValue(true)
            else
                mLiveData.postValue(false)
        }
        return mLiveData

    }
}