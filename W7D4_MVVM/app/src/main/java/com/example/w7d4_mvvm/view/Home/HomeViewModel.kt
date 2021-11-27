package com.example.w7d4_mvvm.view.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.w7d4_mvvm.model.User
import com.example.w7d4_mvvm.network.UserService
import com.example.w7d4_mvvm.repository.UserRepository

class HomeViewModel: ViewModel() {
    var userRepository = UserRepository()
    fun getUsers():LiveData<List<User>>{
        return userRepository.getAllUsers()
    }
}