package com.example.mvvm.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.repostiory.UserRepostiory

class RegisterViewModel:ViewModel() {

    fun register(email:String,username:String,password:String,avatar:String):LiveData<Boolean>{
        var mLiveData= MutableLiveData<Boolean>()
        UserRepostiory().register(username, password, email, avatar).observeForever {
            if(it.username.isNotEmpty()&&it.email.isNotEmpty()&&it.password.isNotEmpty()){
                mLiveData.postValue(true)
            }else{
                mLiveData.postValue(false)
            }

        }
        return  mLiveData
    }
}