package com.twq.projecttest.view.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.projecttest.repository.UserRepository

class RegistrationViewModel : ViewModel() {
    fun register(username:String , password:String): LiveData<Boolean> {
        var mLiveData = MutableLiveData<Boolean>()
        UserRepository().register(username,password).observeForever{
            if(it.username.isNotEmpty()&&it.password.isNotEmpty()){
                mLiveData.postValue(true)
            }else{
                mLiveData.postValue(false)
            }
        }
        return mLiveData
    }
}