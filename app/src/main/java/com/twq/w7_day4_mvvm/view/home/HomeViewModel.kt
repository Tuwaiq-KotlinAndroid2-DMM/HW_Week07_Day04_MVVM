package com.twq.w7_day4_mvvm.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.repository.HomeRepository

class HomeViewModel: ViewModel() {

    var homeRepositry= HomeRepository()
    fun getUser(): LiveData<List<User>> {
        return homeRepositry.getAllUser()
    }
}