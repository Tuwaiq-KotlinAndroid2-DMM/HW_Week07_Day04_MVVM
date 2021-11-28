package com.tuwaq.hww7d4.view.home
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tuwaq.hww7d4.model.User
import com.tuwaq.hww7d4.repository.HomeRepository

class HomeViewModel:ViewModel() {

    var homeRepositry= HomeRepository()
    fun getUser(): LiveData<List<User>>{
        return homeRepositry.getAllUser()
    }
}