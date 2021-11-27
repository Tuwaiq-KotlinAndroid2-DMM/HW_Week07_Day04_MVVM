package com.twq.w7_day4_mvvm.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.repository.UserRepository

class HomeViewModel: ViewModel() {
    var userRepository = UserRepository()
    fun getUsers():LiveData<List<User>>{
        return userRepository.getAllUsers()
    }
}