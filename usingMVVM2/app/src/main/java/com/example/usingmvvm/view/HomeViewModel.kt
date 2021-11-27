package com.example.usingmvvm.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.usingmvvm.model.User

class HomeViewModel: ViewModel() {

    var UserRepository = com.example.usingmvvm.repository.UserRepository()

    fun getUserData(): LiveData<List<User>> {
        return UserRepository.getuserdata()

    }
}