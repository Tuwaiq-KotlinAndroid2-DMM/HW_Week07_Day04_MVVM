package com.example.day34practicemvvmproject.View.Login

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.day34practicemvvmproject.Repository.UserRepository
import com.example.day34practicemvvmproject.Util.Helper

class LoginViewModel: ViewModel() {

    fun login (sharedPref: SharedPreferences, username: String, password: String): LiveData<Boolean>{
        val liveData = MutableLiveData<Boolean>()

        UserRepository().getUser(username, password).observeForever {
            Log.d(TAG, "login: ${it.username}")
            Helper().loginSession(sharedPref, it)
            liveData.postValue(it.id.isNotEmpty())
        }

        return liveData
    }
}