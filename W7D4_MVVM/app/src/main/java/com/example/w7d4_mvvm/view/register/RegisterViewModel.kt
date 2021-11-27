package com.example.w7d4_mvvm.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.w7d4_mvvm.repository.UserRepository

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