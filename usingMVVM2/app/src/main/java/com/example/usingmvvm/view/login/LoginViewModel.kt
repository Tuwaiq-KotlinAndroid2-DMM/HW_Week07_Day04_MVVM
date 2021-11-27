package com.example.usingmvvm.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usingmvvm.model.User
import com.example.usingmvvm.network.UserService
import com.example.usingmvvm.repository.UserRepository

class LoginViewModel: ViewModel() {
    fun login(username:String, password: String): LiveData<Boolean>{
        var mLiveData = MutableLiveData<Boolean>()
        UserRepository().login(username,password).observeForever{
            if(it.username!!.isNotEmpty())
                mLiveData.postValue(true)
            else
                mLiveData.postValue(false)

        }

        return mLiveData
    }


}