package com.example.mvvm.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.User
import com.example.mvvm.repostiory.UserRepostiory

class LoginViewModel:ViewModel() {


    fun login(username:String,password:String):LiveData<Boolean>{

        var mLiveData=MutableLiveData<Boolean>()
        UserRepostiory().login(username, password).observeForever {
            if(it.username.isNotEmpty()){
                mLiveData.postValue(true)
            }else{
                mLiveData.postValue(false)
            }
         }

        return mLiveData
    }
}