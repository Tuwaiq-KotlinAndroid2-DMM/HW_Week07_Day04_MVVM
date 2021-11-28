package com.twq.mvvm_project_review.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.mvvm_project_review.repository.LoginRepository

class LoginViewModel : ViewModel() {

    fun login(username: String, password: String): LiveData<Boolean> {
        var mutableLiveData = MutableLiveData<Boolean>()
        LoginRepository().login(username, password).observeForever {

            if (it.username.isNotEmpty()) {
                mutableLiveData.postValue(true)
            } else {
                mutableLiveData.postValue(false)
            }
        }

        return mutableLiveData
    }
}