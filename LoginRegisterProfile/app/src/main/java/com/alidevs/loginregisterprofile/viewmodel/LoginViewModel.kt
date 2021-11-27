package com.alidevs.loginregisterprofile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alidevs.loginregisterprofile.model.UserModel
import com.alidevs.loginregisterprofile.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel constructor(private val repository: UserRepository) : ViewModel() {

	val userLiveData = MutableLiveData<UserModel>()

	fun userLogin(email: String, password: String) {
		CoroutineScope(Dispatchers.IO).launch {
			val response = repository.getUser(email)
			withContext(Dispatchers.Main) {
				if (!response.isSuccessful) {
					userLiveData.value = null
					return@withContext
				}

				response.body()?.let { userList ->
					val user = if (userList.isNotEmpty()) userList[0] else null
					userLiveData.value = user.takeIf { user != null && user.password == password }
				}
			}
		}
	}

}