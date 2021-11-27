package com.example.mvvm.view.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.User
import com.example.mvvm.repostiory.UserRepostiory

class HomeViewModel: ViewModel() {


    fun getUsers(): LiveData<List<User>> {
        return UserRepostiory().getAllUser()
    }

}