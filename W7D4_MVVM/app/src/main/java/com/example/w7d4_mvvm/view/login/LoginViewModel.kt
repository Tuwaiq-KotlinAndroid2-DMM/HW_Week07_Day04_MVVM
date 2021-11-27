package com.example.w7d4_mvvm.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.w7d4_mvvm.model.User
import com.example.w7d4_mvvm.repository.UserRepository

class LoginViewModel: ViewModel() {

    fun login(username: String, password: String): LiveData<Boolean>{
        var mLiveData = MutableLiveData<Boolean>()

        UserRepository().login(username,password).observeForever {
            if (it.username.isNotEmpty())
                mLiveData.postValue(true)
            else
                mLiveData.postValue(false)
        }
        return mLiveData
    }

}