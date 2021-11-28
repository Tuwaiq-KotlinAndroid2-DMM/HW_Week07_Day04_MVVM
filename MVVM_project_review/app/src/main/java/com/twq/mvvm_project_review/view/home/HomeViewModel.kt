package com.twq.mvvm_project_review.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twq.mvvm_project_review.model.User
import com.twq.mvvm_project_review.repository.HomeRepository

class HomeViewModel: ViewModel() {
    val homeRepository = HomeRepository()

    fun getAllUsers (): MutableLiveData<List<User>> {
        val mLiveData = MutableLiveData<List<User>>()
         homeRepository.getAllUser().observeForever{
             mLiveData.postValue(it)
         }
        return mLiveData
    }
}
