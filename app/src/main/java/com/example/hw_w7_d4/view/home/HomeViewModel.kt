package com.example.hw_w7_d4.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_w7_d4.model.User
import com.example.hw_w7_d4.repository.HomeRepository

class HomeViewModel:ViewModel() {

    var homeRepositry=HomeRepository()
    fun getUser(): LiveData<List<User>>{
        return homeRepositry.getAllUser()
    }
}