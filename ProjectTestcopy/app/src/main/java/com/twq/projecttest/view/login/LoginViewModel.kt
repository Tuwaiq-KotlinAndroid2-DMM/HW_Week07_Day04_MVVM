package com.twq.projecttest.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twq.projecttest.model.User
import com.twq.projecttest.repository.UserRepository

class LoginViewModel : ViewModel() {

    fun login(username:String , password:String):LiveData<Boolean>{
        var mLiveData = MutableLiveData<Boolean>()
        UserRepository().login(username,password).observeForever{
            if(it.username.isNotEmpty()){
                mLiveData.postValue(true)
            }else{
                mLiveData.postValue(false)
            }

        }
        return mLiveData
    }
    var userRepository = UserRepository()
    fun getUserData(username: String,password: String):LiveData<User>{
        return userRepository.profile(username)
    }
}