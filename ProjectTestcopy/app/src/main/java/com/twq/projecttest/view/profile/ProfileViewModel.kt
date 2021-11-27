package com.twq.projecttest.view.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.twq.projecttest.model.User
import com.twq.projecttest.repository.UserRepository

class ProfileViewModel: ViewModel() {

    var profile = UserRepository()
    fun getUserData(username: String):LiveData<User>{
        return profile.profile(username)
    }
}