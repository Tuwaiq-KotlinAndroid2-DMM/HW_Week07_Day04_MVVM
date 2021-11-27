package com.alidevs.loginregisterprofile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alidevs.loginregisterprofile.model.UserModel
import com.alidevs.loginregisterprofile.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel constructor(private val repository: UserRepository) : ViewModel() {

	val userLiveData = MutableLiveData<UserModel>()

	fun userRegister(userModel: UserModel) {
		CoroutineScope(Dispatchers.IO).launch {
			val response = repository.createUser(userModel)
			withContext(Dispatchers.Main) {
				if (!response.isSuccessful) {
					userLiveData.value = null
					return@withContext
				}

				response.body()?.let {
					userLiveData.value = it
				}
			}
		}
	}

}