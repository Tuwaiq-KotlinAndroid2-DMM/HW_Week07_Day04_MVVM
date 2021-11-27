package com.twq.projecttest.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.twq.projecttest.model.User
import com.twq.projecttest.repository.UserRepository

class HomeViewModel: ViewModel() {

    var users = UserRepository()
    fun getUserData(): LiveData<List<User>> {
        return users.users()
    }
}