package com.twq.w7_day4_mvvm.repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.twq.w7_day4_mvvm.model.User
import com.twq.w7_day4_mvvm.network.API
import com.twq.w7_day4_mvvm.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    var userService = API.getInstance().create(UserService::class.java)

    fun login(username: String, password: String): LiveData<User>{
        var mLiveData = MutableLiveData<User>()

        userService.getUserByUsernameAndPassword(username,password)
            .enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    var listOfUsers = response.body()
                    if (listOfUsers?.isNotEmpty() == true){
                        mLiveData.postValue(listOfUsers[0])
                    } else{
                        mLiveData.postValue(User("","","","",""))
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        return mLiveData
    }

    fun register(email: String, password: String, username: String): LiveData<User>{
        var mLiveData = MutableLiveData<User>()

        userService.registerNewUser(User(email,"1",password,"https://st3.depositphotos.com/1007566/13175/v/600/depositphotos_131750410-stock-illustration-woman-female-avatar-character.jpg",username))
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful){
                        mLiveData.postValue(response.body())
                    }
                    else
                        mLiveData.postValue(User("","","","",""))
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        return mLiveData
    }

    fun getAllUsers(): MutableLiveData<List<User>>{

        var mLiveData = MutableLiveData<List<User>>()

        val userService = API.getInstance().create(UserService::class.java)
        val usersList = userService.getAllUsers()
            .enqueue(object : Callback<List<User>>{
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    mLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        return mLiveData
    }
}