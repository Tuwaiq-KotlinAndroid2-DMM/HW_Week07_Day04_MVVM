package com.twq.w7_day4_mvvm.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.repository.UserRepository

class LoginViewModel: ViewModel() {

    fun login(username:String,password:String): LiveData<Boolean>{
        var mutableLiveData= MutableLiveData<Boolean>()

        UserRepository().login(username,password).observeForever{

            if (it.username.isNotEmpty())
                mutableLiveData.postValue(true)
            else
                mutableLiveData.postValue(false)

        }

      return mutableLiveData
    }
}