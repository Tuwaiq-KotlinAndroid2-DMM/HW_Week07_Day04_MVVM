package com.twq.mvvm_project_review.view.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.mvvm_project_review.repository.LoginRepository
import com.twq.mvvm_project_review.repository.RegisterRepository


class RegisterationViewModel : ViewModel() {

    private val userRepository = RegisterRepository()

    fun addUser(
        id: String? = "1", username: String,
        email: String, password: String, imgUrl: String? = "no picture"
    ): LiveData<Boolean> {

        var mutableLiveData = MutableLiveData<Boolean>()
        userRepository.addUser(null, username, email, password, null)
            .observeForever {
                    mutableLiveData.postValue(true)
            }
        return mutableLiveData
    }
}